package service.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import util.exception.OrderingException;

@Service("fileReader")
public class FileReaderImpl implements FileReader  {

    @Override
    public String readRulesConfigFile() throws OrderingException {
        String data = "";
        ClassPathResource cpr = new ClassPathResource("config.txt");

        if(!cpr.exists()) {
            throw new OrderingException();
        }

        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
            return data;
        } catch (IOException e) {
            throw new OrderingException();
        }
    }
}
