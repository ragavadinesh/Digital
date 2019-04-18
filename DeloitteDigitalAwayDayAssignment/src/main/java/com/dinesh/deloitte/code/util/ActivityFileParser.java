package com.dinesh.deloitte.code.util;

import com.dinesh.deloitte.code.exception.ActivityHandlerException;
import com.dinesh.deloitte.code.model.Activity;

import static com.dinesh.deloitte.code.util.ActivityMapper.map;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by uuchey on 23/05/2016.
 */
public class ActivityFileParser {

    private String fileName;

    public ActivityFileParser(String fileName){
        this.fileName = fileName;
    }

    public List<Activity> parse() throws IOException, ActivityHandlerException {
        List<Activity> activities = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            final File file = new File(getFileName());
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                activities.add(map(line));
            }
        }catch (IOException e){
            throw new ActivityHandlerException("Error reading input file: "+fileName,e);
        }finally {
            fileReader.close();
            bufferedReader.close();
        }
        return activities;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
