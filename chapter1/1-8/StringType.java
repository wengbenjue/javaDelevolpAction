package com.jdon.jserver.connector.data;

import java.nio.*;
import java.io.*;
import java.net.*;

import com.jdon.util.Debug;

/**
 * Visitable��������
 * <p>Copyright: Jdon.com Copyright (c) 2003</p>
 * <p>Company: �Ϻ����������������޹�˾</p>
 * @author banq
 * @version 1.0
 */
public class StringType implements Linkable {

  private String content = null;
  private int msgType;
  private ByteBuffer byteBuffer = null;

  public StringType(int msgType) {
    this.msgType = msgType;
  }

  public String getContent() {
    return content;
  }
  public void setContent(String content){
     this.content = content;
  }

  public void accpet(QueueWorker worker) throws Exception {
    worker.run(msgType, this);
  }

  public OutputStream getOutputStream() {
    OutputStream outputStream = null;
    try {
      outputStream = DataTypeHelper.writeString(content);
    } catch (Exception ex) {
    }
    return outputStream;
  }

  public void setInputStream(InputStream in) {
    try {
      this.content = DataTypeHelper.getString(in);
    } catch (Exception ex) {
    }
  }

}