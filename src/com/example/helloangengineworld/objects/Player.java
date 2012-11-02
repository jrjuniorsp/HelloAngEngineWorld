package com.example.helloangengineworld.objects;

import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.example.helloangengineworld.HelloAndEngineWorld;
import com.example.helloangengineworld.helpers.AccelerometerHelper;

public class Player extends GameObject {
	
	final int DEFAULT_VELOCITY = 200;
	
	 boolean jumping = false;


	public Player(float pX, float pY, ITiledTextureRegion pTiledTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTiledTextureRegion, pVertexBufferObjectManager);
	}

	@Override
	public void move() {
		this.mPhysicsHandler.setVelocityX(-AccelerometerHelper.TILT_X * 10);
		this.mPhysicsHandler.setVelocityY(AccelerometerHelper.TILT_Y * 10);
		setRotation(-AccelerometerHelper.TILT_X * 7);
		outOfScreen();
	}
	
	private void outOfScreen() {
		if (mX > HelloAndEngineWorld.CAMERA_WIDTH) {
			mX = 0;
		}
	}
	
}
