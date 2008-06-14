/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.messaging.tests.unit.core.client.impl;

import org.jboss.messaging.core.client.ConnectionParams;
import org.jboss.messaging.core.client.impl.ConnectionParamsImpl;
import org.jboss.messaging.tests.util.RandomUtil;
import org.jboss.messaging.tests.util.UnitTestCase;

/**
 * 
 * A ConnectionParamsImplTest
 * 
 * @author <a href="mailto:tim.fox@jboss.com">Tim Fox</a>
 *
 */
public class ConnectionParamsImplTest extends UnitTestCase
{
   
   public void testDefaults()
   {
      ConnectionParams cp = new ConnectionParamsImpl();
      
      assertEquals(ConnectionParamsImpl.DEFAULT_INVM_DISABLED, cp.isInVMDisabled());
      assertEquals(ConnectionParamsImpl.DEFAULT_SSL_ENABLED, cp.isSSLEnabled());
      assertEquals(ConnectionParamsImpl.DEFAULT_TCP_NODELAY, cp.isTcpNoDelay());
      assertEquals(ConnectionParamsImpl.DEFAULT_CALL_TIMEOUT, cp.getCallTimeout());
      assertEquals(ConnectionParamsImpl.DEFAULT_PING_INTERVAL, cp.getPingInterval());
      assertEquals(ConnectionParamsImpl.DEFAULT_PING_TIMEOUT, cp.getPingTimeout());
      assertEquals(ConnectionParamsImpl.DEFAULT_TCP_RECEIVE_BUFFER_SIZE, cp.getTcpReceiveBufferSize());
      assertEquals(ConnectionParamsImpl.DEFAULT_TCP_SEND_BUFFER_SIZE, cp.getTcpSendBufferSize());
      assertEquals(null, cp.getKeyStorePath());
      assertEquals(null, cp.getKeyStorePassword());
      assertEquals(null, cp.getTrustStorePath());
      assertEquals(null, cp.getTrustStorePassword());
   }
   
   public void testURI()
   {
      ConnectionParams cp = new ConnectionParamsImpl();
      
      StringBuffer buff = new StringBuffer();
      buff.append("?").append("callTimeout=").append(ConnectionParamsImpl.DEFAULT_CALL_TIMEOUT);
      buff.append("&").append("pingInterval=").append(ConnectionParamsImpl.DEFAULT_PING_INTERVAL);
      buff.append("&").append("pingTimeout=").append(ConnectionParamsImpl.DEFAULT_PING_TIMEOUT);
      buff.append("&").append("inVMDisabled=").append(ConnectionParamsImpl.DEFAULT_INVM_DISABLED);
      buff.append("&").append("tcpNoDelay=").append(ConnectionParamsImpl.DEFAULT_TCP_NODELAY);
      buff.append("&").append("tcpReceiveBufferSize=").append(ConnectionParamsImpl.DEFAULT_TCP_RECEIVE_BUFFER_SIZE);
      buff.append("&").append("tcpSendBufferSize=").append(ConnectionParamsImpl.DEFAULT_TCP_SEND_BUFFER_SIZE);
      buff.append("&").append("sslEnabled=").append(ConnectionParamsImpl.DEFAULT_SSL_ENABLED);
      buff.append("&").append("keyStorePath=").append((String)null);
      buff.append("&").append("trustStorePath=").append((String)null);
      
      assertEquals(buff.toString(), cp.getURI());
   }
   
   public void testSetAndGetAttributes()
   {
      for (int j = 0; j < 100; j++)
      {
         ConnectionParams cp = new ConnectionParamsImpl();
         
         boolean b = RandomUtil.randomBoolean();
         cp.setInVMDisabled(b);
         assertEquals(b, cp.isInVMDisabled());
         
         b = RandomUtil.randomBoolean();
         cp.setSSLEnabled(b);
         assertEquals(b, cp.isSSLEnabled());
         
         b = RandomUtil.randomBoolean();
         cp.setTcpNoDelay(b);
         assertEquals(b, cp.isTcpNoDelay());
         
         int i = RandomUtil.randomInt();
         cp.setCallTimeout(i);
         assertEquals(i, cp.getCallTimeout());
         
         long l = RandomUtil.randomLong();
         cp.setPingInterval(l);
         assertEquals(l, cp.getPingInterval());
         
         l = RandomUtil.randomLong();
         cp.setPingTimeout(l);
         assertEquals(l, cp.getPingTimeout());
         
         i = RandomUtil.randomInt();
         cp.setTcpReceiveBufferSize(i);
         assertEquals(i, cp.getTcpReceiveBufferSize());
         
         i = RandomUtil.randomInt();
         cp.setTcpSendBufferSize(i);
         assertEquals(i, cp.getTcpSendBufferSize());
         
         String s = RandomUtil.randomString();
         cp.setKeyStorePath(s);
         assertEquals(s, cp.getKeyStorePath());
         
         s = RandomUtil.randomString();
         cp.setKeyStorePassword(s);
         assertEquals(s, cp.getKeyStorePassword());
         
         s = RandomUtil.randomString();
         cp.setTrustStorePath(s);
         assertEquals(s, cp.getTrustStorePath());
         
         s = RandomUtil.randomString();
         cp.setTrustStorePassword(s);
         assertEquals(s, cp.getTrustStorePassword());   
      }      
   }
   
   // Private -----------------------------------------------------------------------------------------------------------

}
