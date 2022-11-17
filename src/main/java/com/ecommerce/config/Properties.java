package com.ecommerce.config;

public class Properties {

    public static final String WRITE_PATH = System.getProperty("user.home") + "/ecommerce/"; // user.my file.code.images is the path to the User's home directory
    public static final String READ_PATH= System.getProperty("user.home") + "/ecommerce/"; // same is WRITE_PATH for better reading

    // For docker volume
    // public static final String WRITE_PATH = "/Documents/docker-data/static_data/ecommerce/";
    // public static final String READ_PATH  = "/Documents/docker-data/static_data/ecommerce/";

    public static final String USER_FOLDER =  "user/"; //for saving profile photos in different folders
    public static final String PRODUCT_FOLDER = "product/"; // for saving status files in different folders;

    public static final String TEMP_LOCATION ="/tmp";
    public static final long MAX_FILE_SIZE =10 * 1024 * 1024;
    public static final long MAX_REQUEST_SIZE = 50 * 1024 * 1024;
    public static final int FILE_THRESHOLD_SIZE= 50 * 1024 * 1024;


}
