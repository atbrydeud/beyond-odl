package com.inocybe.parrot;

public class Drone
{
	public native void connect();
	
	public native void takeoff();
  
        public native void land();

        public native void pilot(int pitch, int yaw, int roll, int gaz);

	public static void main(String[] args)
	{
		System.loadLibrary("DroneNative");
		new Drone().helloNative();
	}
}
