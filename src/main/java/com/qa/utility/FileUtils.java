package com.qa.utility;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtils {

    private FileUtils() {
    }

    @SneakyThrows
    public static String readJsonAndReturnString(String filePath) {
        return Files.readAllBytes(Paths.get(filePath)).toString();
    }

    @SneakyThrows
    public static void storeJsonResponseInFile(String filePath, Response response) {
        Files.write(Paths.get(filePath), response.asByteArray());
    }


}
