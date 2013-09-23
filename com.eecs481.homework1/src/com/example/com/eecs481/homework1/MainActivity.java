package com.example.com.eecs481.homework1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	static boolean player1 = true;
	ImageButton ticTacArray[];
	TextView winMessage;
	Button restart;
	int tictacState[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ticTacArray = new ImageButton[9];
		ticTacArray[0] = (ImageButton) findViewById(R.id.button00);
		ticTacArray[1] = (ImageButton) findViewById(R.id.Button01);
		ticTacArray[2] = (ImageButton) findViewById(R.id.Button02);
		ticTacArray[3] = (ImageButton) findViewById(R.id.Button03);
		ticTacArray[4] = (ImageButton) findViewById(R.id.Button04);
		ticTacArray[5] = (ImageButton) findViewById(R.id.Button05);
		ticTacArray[6] = (ImageButton) findViewById(R.id.Button06);
		ticTacArray[7] = (ImageButton) findViewById(R.id.Button07);
		ticTacArray[8] = (ImageButton) findViewById(R.id.Button08);
		
		winMessage = (TextView) findViewById(R.id.textView2);
		restart = (Button) findViewById(R.id.Restart);
		tictacState = new int[9];
		for(int i = 0;i < 9; i++) {
			tictacState[i] = 0;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * Listener for Tic Tac Toe Buttons
	 * @param view which tic tac toe is displayed
	 */
	public void onTicTacClick(View view) {
		// Declare VariablesView view) {
		String toastText;

		// Display Toast Text
		if(player1) {
			toastText = "O's Turn";
		}
		else {
			toastText = "X's Turn";
		}

		Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
		fillImageButton(view);
	}

	/**
	 * Change ImageButton to 'X' or 'O' depending on which player's turn
	 * @param view which tic tac toe is displayed
	 */
	public void fillImageButton(View view) {
		int imageId;
		int playerState = 0;
		boolean win = false;
		if(player1) {
			imageId = R.drawable.x;
			player1 = false;
			playerState = 1;
		}
		else {
			imageId = R.drawable.o;
			player1 = true;
			playerState = 2;
		}

		switch(view.getId()) {
		case R.id.button00: ticTacArray[0].setImageResource(imageId);
		tictacState[0] = playerState;
		win = checkWin(tictacState, playerState, 0);
		break;
		case R.id.Button01: ticTacArray[1].setImageResource(imageId);
		tictacState[1] = playerState;
		win = checkWin(tictacState, playerState, 1);
		break;
		case R.id.Button02: ticTacArray[2].setImageResource(imageId);
		tictacState[2] = playerState;
		win = checkWin(tictacState, playerState, 2);
		break;
		case R.id.Button03: ticTacArray[3].setImageResource(imageId);
		tictacState[3] = playerState;
		win = checkWin(tictacState, playerState, 3);
		break;
		case R.id.Button04: ticTacArray[4].setImageResource(imageId);
		tictacState[4] = playerState;
		win = checkWin(tictacState, playerState, 4);
		break;
		case R.id.Button05: ticTacArray[5].setImageResource(imageId);
		tictacState[5] = playerState;
		win = checkWin(tictacState, playerState, 5);
		break;
		case R.id.Button06: ticTacArray[6].setImageResource(imageId);
		tictacState[6] = playerState;
		win = checkWin(tictacState, playerState, 6);
		break;
		case R.id.Button07: ticTacArray[7].setImageResource(imageId);
		tictacState[7] = playerState;
		win = checkWin(tictacState, playerState, 7);
		break;
		case R.id.Button08: ticTacArray[8].setImageResource(imageId);
		tictacState[8] = playerState;
		win = checkWin(tictacState, playerState, 8);
		break;
		}
		
		if(win) {
			if(playerState == 1) {
				winMessage.setText("X'S WIN");
			}
			else {
				winMessage.setText("O'S WIN");
			}
			winMessage.setVisibility(View.VISIBLE);
			restart.setVisibility(View.VISIBLE);
		}
	}
	
	public void onRestart(View view) {
		for(int i = 0; i < 9; i++) {
			ticTacArray[i].setImageResource(android.R.color.transparent);
			tictacState[i] = 0;
		}
		winMessage.setVisibility(View.GONE);
		restart.setVisibility(View.GONE);
	}
	
	public boolean checkWin(int [] tictacState, int num, int index) {
		switch(index) {
		case 0:
			if(tictacState[1] == num && tictacState[2] == num)
				return true;
			else if(tictacState[3] == num && tictacState[6] == num)
				return true;
			else if(tictacState[4] == num && tictacState[8] == num)
				return true;
			break;
		case 1:
			if(tictacState[0] == num && tictacState[2] == num)
				return true;
			else if(tictacState[4] == num && tictacState[7] == num)
				return true;
			break;
		case 2:
			if(tictacState[0] == num && tictacState[1] == num)
				return true;
			else if(tictacState[5] == num && tictacState[8] == num)
				return true;
			else if(tictacState[4] == num && tictacState[6] == num)
				return true;
			break;
		case 3:
			if(tictacState[0] == num && tictacState[6] == num)
				return true;
			else if(tictacState[4] == num && tictacState[5] == num)
				return true;
			break;
		case 4:
			if(tictacState[1] == num && tictacState[7] == num)
				return true;
			else if(tictacState[3] == num && tictacState[5] == num)
				return true;
			break;
		case 5:
			if(tictacState[2] == num && tictacState[8] == num)
				return true;
			else if(tictacState[3] == num && tictacState[4] == num)
				return true;
			break;
		case 6:
			if(tictacState[0] == num && tictacState[3] == num)
				return true;
			else if(tictacState[4] == num && tictacState[2] == num)
				return true;
			else if(tictacState[7] == num && tictacState[8] == num)
				return true;
			break;
		case 7:
			if(tictacState[1] == num && tictacState[4] == num)
				return true;
			else if(tictacState[6] == num && tictacState[8] == num)
				return true;
			break;
		case 8:
			if(tictacState[2] == num && tictacState[5] == num)
				return true;
			else if(tictacState[0] == num && tictacState[4] == num)
				return true;
			else if(tictacState[6] == num && tictacState[7] == num)
				return true;
			break;
		}
		return false;
	}
}
