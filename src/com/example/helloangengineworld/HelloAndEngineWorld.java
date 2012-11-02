package com.example.helloangengineworld;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.util.FPSLogger;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.example.helloangengineworld.helpers.AccelerometerHelper;
import com.example.helloangengineworld.objects.Player;

public class HelloAndEngineWorld extends SimpleBaseGameActivity {
	
	public static final int CAMERA_WIDTH = 320;
	public static final int CAMERA_HEIGHT = 480;
	
	private BitmapTextureAtlas mBitmapTextureAtlas;
	private TiledTextureRegion mPlayerTiledTextureRegion;
	private Camera camera;
	private Scene mainScene;

	@Override
	public EngineOptions onCreateEngineOptions() {
		camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
		//Inicia o Accelerometer
		AccelerometerHelper mAccelerometerHelper = new AccelerometerHelper(this);
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		mBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 32, 32);
		mPlayerTiledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(this.mBitmapTextureAtlas, this, "face_box.png",0 , 0, 1, 1);
		mBitmapTextureAtlas.load();
	}

	@Override
	protected Scene onCreateScene() {
	    this.mEngine.registerUpdateHandler(new FPSLogger()); // logs the frame rate
	 
	    // Create Scene and set background colour to (1, 1, 1) = white
	    this.mainScene = new Scene();
	    this.mainScene.setBackground(new Background(1, 1, 1));
	 
	    // Centre the player on the camera.
	    final int centerX = (CAMERA_WIDTH - mBitmapTextureAtlas.getWidth()) / 2;
	    final int centerY = (CAMERA_HEIGHT - mBitmapTextureAtlas.getHeight()) / 2;
	 
	    /* Create the player and add it to the scene. */
	    final Player oPlayer = new Player(centerX, centerY, mPlayerTiledTextureRegion, getVertexBufferObjectManager());
	    this.mainScene.attachChild(oPlayer);
	 
	    return this.mainScene;
	}


}
