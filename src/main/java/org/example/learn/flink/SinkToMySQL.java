package org.example.learn.flink;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SinkToMySQL extends RichSinkFunction {
    public SinkToMySQL() {
        super();
    }
}
