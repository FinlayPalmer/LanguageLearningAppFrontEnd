package com.narration;

// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.polly.PollyClient;
import software.amazon.awssdk.services.polly.model.DescribeVoicesRequest;
import software.amazon.awssdk.services.polly.model.DescribeVoicesResponse;
import software.amazon.awssdk.services.polly.model.OutputFormat;
import software.amazon.awssdk.services.polly.model.PollyException;
import software.amazon.awssdk.services.polly.model.SynthesizeSpeechRequest;
import software.amazon.awssdk.services.polly.model.SynthesizeSpeechResponse;
import software.amazon.awssdk.services.polly.model.Voice;


import java.io.IOException;
import java.io.InputStream;

/**
 * The {@code Narrator} class provides functionality to synthesize speech from text
 * using AWS Polly and play the generated audio using the JLayer library.
 * <p>
 * This utility is used to create spoken outputs in applications requiring text-to-speech (TTS).
 */
public class Narrator {
    private static final Logger logger = LoggerFactory.getLogger(Narrator.class);

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private Narrator() {
    }

    /**
     * Synthesizes speech from the provided text and plays it using the JLayer audio player.
     *
     * @param text the text to be spoken
     */
    public static void playSound(String text) {
        logger.info("Initializing PollyClient for text: {}", text);

        try (PollyClient polly = PollyClient.builder().region(Region.EU_WEST_1).build()) {
            logger.info("PollyClient created successfully");
            talkPolly(polly, text);
        } catch (Exception e) {
            logger.error("Error initializing PollyClient: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Handles the speech synthesis and playback process by interacting with AWS Polly
     * and playing the generated audio stream.
     *
     * @param polly the {@link PollyClient} instance to interact with AWS Polly
     * @param text  the text to synthesize and play
     */
    private static void talkPolly(PollyClient polly, String text) {
        try {
            DescribeVoicesRequest describeVoiceRequest = DescribeVoicesRequest.builder()
                    .engine("standard")
                    .build();
            DescribeVoicesResponse describeVoicesResult = polly.describeVoices(describeVoiceRequest);

            Voice voice = describeVoicesResult.voices().stream()
                    .filter(v -> v.name().equals("Lucia"))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Voice 'Lucia' not found"));

            logger.info("Using voice: {}", voice.name());

            InputStream stream = synthesize(polly, text, voice, OutputFormat.MP3);
            playAudio(stream);

        } catch (PollyException e) {
            logger.error("PollyException occurred: {}", e.awsErrorDetails().errorMessage());
        } catch (IOException e) {
            logger.error("IOException occurred during speech synthesis: {}", e.getMessage());
        } catch (JavaLayerException e) {
            logger.error("Error playing audio: {}", e.getMessage());
        }
    }

    /**
     * Synthesizes speech using AWS Polly and returns the audio stream.
     *
     * @param polly   the {@link PollyClient} instance
     * @param text    the text to synthesize
     * @param voice   the {@link Voice} to use for the speech
     * @param format  the {@link OutputFormat} of the audio stream
     * @return an {@link InputStream} containing the synthesized audio
     * @throws IOException if an I/O error occurs during synthesis
     */
    private static InputStream synthesize(PollyClient polly, String text, Voice voice, OutputFormat format)
            throws IOException {
        SynthesizeSpeechRequest synthReq = SynthesizeSpeechRequest.builder()
                .text(text)
                .voiceId(voice.id())
                .outputFormat(format)
                .build();

        ResponseInputStream<SynthesizeSpeechResponse> synthRes = polly.synthesizeSpeech(synthReq);
        return synthRes;
    }

    /**
     * Plays the provided audio stream using the JLayer {@link AdvancedPlayer}.
     *
     * @param stream the audio stream to play
     * @throws JavaLayerException if an error occurs during audio playback
     * @throws IOException        if an I/O error occurs while reading the stream
     */
    private static void playAudio(InputStream stream) throws JavaLayerException, IOException {
        AdvancedPlayer player = new AdvancedPlayer(stream,
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());
        player.setPlayBackListener(new PlaybackListener() {
        });
        player.play();
    }
}