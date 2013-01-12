package com.pub.util;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;

public class AhpoTest {

	public static void main(String[] args) {
		TaskScheduler ts  =new TaskScheduler() {
			
			@Override
			public ScheduledFuture scheduleWithFixedDelay(Runnable arg0, Date arg1,
					long arg2) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ScheduledFuture scheduleWithFixedDelay(Runnable arg0, long arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ScheduledFuture scheduleAtFixedRate(Runnable arg0, Date arg1,
					long arg2) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ScheduledFuture scheduleAtFixedRate(Runnable arg0, long arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ScheduledFuture schedule(Runnable arg0, Date arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ScheduledFuture schedule(Runnable arg0, Trigger arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
