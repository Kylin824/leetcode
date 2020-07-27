package org.example.learn.flink;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.text.Format;
import java.text.SimpleDateFormat;


public class SinkToMySQL extends RichSinkFunction {
    public SinkToMySQL() {
        super();
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    }
}
