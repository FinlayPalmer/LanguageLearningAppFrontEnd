package com.model;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Matthew Botteon
 * Creates a Story object with different pages of content in Spanish
 */
public class Story {
    private String title;
    private HashMap<Integer, String> content;
    private int currentPage;
    private int bookmarkedPage;
    private boolean isCompleted;
    private UUID storyID;

    /**
     * Creates a new instance of a Story without a UUID
     * 
     * @param title The title of the story
     * @param content The content of each page is a String mapped to an integer page number
     */
    public Story(String title, HashMap<Integer, String> content) {
        this.title = title;
        this.content = content;
        this.currentPage = 1;
        this.isCompleted = false;
        this.storyID = UUID.randomUUID();
    }

    /**
     * Creates a new instance of a Story without a UUID
     * 
     * @param title The title of the story
     * @param content The content of each page is a String mapped to an integer page number
     * @param storyID The UUID of the Story object
     */
    public Story(String title, HashMap<Integer, String> content, UUID storyID) {
        this.title = title;
        this.content = content;
        this.currentPage = 1;
        this.isCompleted = false;
        this.storyID = storyID;
    }

    /**
     * Returns the title of the story
     * 
     * @return The title of the story
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the content on the current page of the story
     * 
     * @return The content on the current page of the story
     */
    public String getContent() {
        return content.get(currentPage);
    }

    /**
     * Returns the current page number of the story
     * 
     * @return The current page number
     */
    public int getCurrentPageNumber() {
        return currentPage;
    }

    /**
     * Returns the page number the user has bookmarked
     * 
     * @return The bookmarked page number
     */
    public int getBookmarkedPageNumber() {
        return bookmarkedPage;
    }

    /**
     * Returns true if the Story has been completed, false if not
     * 
     * @return True if the Story has been completed
     */
    public boolean getIsCompleted() {
        return isCompleted;
    }

    /**
     * Gets the unique identifier of the Story object
     * @return
     */
    public UUID getUUID() {
        return storyID;
    }

    /**
     * Sets the current page of the story to a given page
     * 
     * @param pageNumber The number of the page to turn to
     */
    public void setCurrentPage(int pageNumber) {
        // Checks the parameter page number is within the size of the story
        if(pageNumber < content.size())
            currentPage = pageNumber;
    }

    /**
     * Overloads the setCurrentPage method to allow for no parameter, in which case the currentPage is just incremented
     */
    public void setCurrentPage() {
        // Checks that incrementing the page will not move the current page out of the story
        if(currentPage < content.size() - 1)
            currentPage++;
    }

    /**
     * Bookmarks the current page for the user to come back to later
     */
    public void bookmarkPage() {
        bookmarkedPage = currentPage;
    }

    /**
     * Sets the current page to the bookmarked page
     */
    public void goToBookmark() {
        currentPage = bookmarkedPage;
    }

    /**
     * Marks the story as completed
     */
    public void markAsCompleted() {
        isCompleted = true;
    }

     /**
     * Starts the story and prints the first page content.
     */
    public void start() {
        System.out.println("Starting story: " + title);
        if (content.containsKey(currentPage)) {
            System.out.println("Page " + currentPage + ": " + content.get(currentPage));
        } else {
            System.out.println("No content available for the current page.");
        }
    }
    
    /**
     * Ends the story, marking it as completed.
     */
    public void end() {
        System.out.println("Ending story: " + title);
        markAsCompleted();
        System.out.println("Story completed.");
    }
}
