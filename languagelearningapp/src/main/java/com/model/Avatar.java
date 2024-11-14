package com.model;

import java.util.ArrayList;

/**
 * @author Matthew Botteon
 * Creates an avatar for the user with several attributes to customize.
 */
public class Avatar {
    private ArrayList<String> avatar;
    private String baseAvatar;
    private ArrayList<String> mouthStyles;
    private ArrayList<String> eyeStyles;
    private ArrayList<String> hairStyles;
    private ArrayList<String> noseStyles;
    private ArrayList<String> hatStyles;

    /**
     * Creates a default ArrayList of the basic avatar.
     */
    public Avatar() {
        // Initialize the avatar ArrayList before adding elements to it
        avatar = new ArrayList<>();
        avatar.add("         __________      ");
        avatar.add("        |          |     ");
        avatar.add("        |          |     ");
        avatar.add("        |          |     ");
        avatar.add("     ------------------  ");
        avatar.add("      (              )   ");
        avatar.add("     (   0        0   )  ");
        avatar.add("    (                  ) ");
        avatar.add("   (         \\/         )");
        avatar.add("   (                    )");
        avatar.add("    (    (________)    ) ");
        avatar.add("     (                )  ");
        avatar.add("      (              )   ");
        avatar.add("       --------------    ");
    }

    /**
     * Constructs an Avatar with various customizable features.
     *
     * @param baseAvatar   The base avatar string (e.g., "orange tiger").
     * @param mouthStyles  The list of mouth styles.
     * @param eyeStyles    The list of eye styles.
     * @param hairStyles   The list of hair styles.
     * @param noseStyles   The list of nose styles.
     * @param hatStyles    The list of hat styles.
     */
    public Avatar(String baseAvatar, ArrayList<String> mouthStyles, ArrayList<String> eyeStyles,
                  ArrayList<String> hairStyles, ArrayList<String> noseStyles, ArrayList<String> hatStyles) {
        this.baseAvatar = baseAvatar;
        this.mouthStyles = mouthStyles;
        this.eyeStyles = eyeStyles;
        this.hairStyles = hairStyles;
        this.noseStyles = noseStyles;
        this.hatStyles = hatStyles;
    }

    /**
     * Returns the base avatar.
     *
     * @return The base avatar string.
     */
    public String getBaseAvatar() {
        return baseAvatar;
    }

    /**
     * Returns the list of mouth styles.
     *
     * @return The ArrayList of mouth styles.
     */
    public ArrayList<String> getMouthStyles() {
        return mouthStyles;
    }

    /**
     * Returns the list of eye styles.
     *
     * @return The ArrayList of eye styles.
     */
    public ArrayList<String> getEyeStyles() {
        return eyeStyles;
    }

    /**
     * Returns the list of hair styles.
     *
     * @return The ArrayList of hair styles.
     */
    public ArrayList<String> getHairStyles() {
        return hairStyles;
    }

    /**
     * Returns the list of nose styles.
     *
     * @return The ArrayList of nose styles.
     */
    public ArrayList<String> getNoseStyles() {
        return noseStyles;
    }

    /**
     * Returns the list of hat styles.
     *
     * @return The ArrayList of hat styles.
     */
    public ArrayList<String> getHatStyles() {
        return hatStyles;
    }

    /**
     * Sets the base avatar.
     *
     * @param baseAvatar The base avatar string to set.
     */
    public void setBaseAvatar(String baseAvatar) {
        this.baseAvatar = baseAvatar;
    }
}
