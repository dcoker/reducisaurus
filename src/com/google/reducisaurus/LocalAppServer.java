/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.reducisaurus;

import com.google.appengine.tools.development.DevAppServerFactory;
import com.google.appengine.tools.development.DevAppServer;

import java.io.File;

public final class LocalAppServer {
  public static void main(String[] args) throws Exception {

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        DevAppServerFactory factory = new DevAppServerFactory();
        File file = new File(".");
        String address = "localhost";
        int port = 9090;
        DevAppServer appserver = factory.createDevAppServer(file, address, port);
        try {
          appserver.start();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    });
    thread.start();
    while (true) {
      Thread.sleep(10 * 1000);
    }
  }
}
