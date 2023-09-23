package com.ingenieriaweb.springboot.web.app.services.Interface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UPLOAD_FILE_SERVICE {

    public Resource load(String filename) throws MalformedURLException;

    public String copy(MultipartFile file) throws IOException;

    public boolean delete(String filename);

    public void deleteAll();

    public void init() throws IOException;

    public Path obtenerPathString(String nombreRuta);


}
