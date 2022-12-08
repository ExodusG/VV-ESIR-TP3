package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TLSSocketFactoryTestMocks {

  @Test
  public void preparedSocket_NullProtocols()  {

    SSLSocket mock=mock(SSLSocket.class);
    when(mock.getSupportedProtocols()).thenReturn(null);
    when(mock.getEnabledProtocols()).thenReturn(null);
    doThrow(new AssertionError()).when(mock).setEnabledProtocols(any(String[].class));
    TLSSocketFactory f=new TLSSocketFactory();
    f.prepareSocket(mock);
  }


  @Test
  public void typical(){
    String[] tab=new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
    String[] tab2=new String[]{"SSLv3", "TLSv1"};
    SSLSocket mock=mock(SSLSocket.class);
    when(mock.getSupportedProtocols()).thenReturn(tab);
    when(mock.getEnabledProtocols()).thenReturn(tab2);
    TLSSocketFactory f=new TLSSocketFactory();
    f.prepareSocket(mock);
    String[] tab3=new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" };
    verify(mock).setEnabledProtocols(tab3);
  }

}
