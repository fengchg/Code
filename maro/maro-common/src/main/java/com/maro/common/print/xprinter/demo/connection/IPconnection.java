package com.maro.common.print.xprinter.demo.connection;

import com.maro.common.print.api.OWConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by alpha on 2018-9-19.
 */
public class IPconnection extends OWConnection {
    private OutputStream out;
    private InputStream in;

    public IPconnection(Socket socket) throws IOException {
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        try {
            out.write(bytes);
        }
        catch (Exception e){

        }
    }

    @Override
    public void write(byte[] bytes, int start, int length) throws IOException {
        try {
            out.write(bytes);
        }
        catch (Exception e){

        }
    }
    @Override
    public int read(byte[] bytes) throws IOException{
        try{
            int result = in.read();
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void close() {
        try {
            out.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void flush() throws IOException {
        try {
            out.flush();
        } catch (Exception e) {
        }
    }
}
