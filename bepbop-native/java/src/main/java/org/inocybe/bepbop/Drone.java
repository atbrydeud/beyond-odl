/*
 * Copyright © 2016 Inocybe Technologies and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.inocybe.bepbop;

public class Drone {

    public Drone() {
        System.loadLibrary("DroneNative");
    }

    public native void connect();

    public native void takeoff();

    public native void land();

    public native void pilot(int pitch, int yaw, int roll, int gaz);

//    public static void main(String[] args) {
//        System.loadLibrary("DroneNative");
//    }
}
