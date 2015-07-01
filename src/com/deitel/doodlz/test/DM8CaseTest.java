package com.deitel.doodlz.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.doodlz.Doodlz;
import com.deitel.doodlz.R;
import com.deitel.doodlz.test.util.TestAccelerationEvent;
import com.deitel.doodlz.test.util.TestCaseUtil;
import com.robotium.solo.Solo;

public class DM8CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public DM8CaseTest() {
		super(Doodlz.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		// String cesOne =
		// "Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Cancel, Display_drawing_screen, Press_Menu, Display_Menu, Press_Clear, Clear_screen, Display_drawing_screen, Press_Menu, Display_Menu, Press_Back, Display_drawing_screen, Press_Menu, Display_Menu, Press_Color, Display_Choose_Color, Display_Set_Color, Change_to_configured_color, Display_drawing_screen, Press_Menu, Display_Menu, Press_Line_Width, Display_Choose_Line_Width, Press_Set_Line_Width, Change_to_configured_width, Display_drawing_screen, Press_Menu, Display_Menu, Press_Save, Display_save_confirmation, Display_insufficient_space, Display_drawing_screen, Press_Menu, Display_Menu, Press_Erase1, Change_color_to_white, Display_drawing_screen, Press_Menu, Display_Menu, Draw, Display_drawing_screen, Press_Menu, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Press_Cancel, Display_Menu, Press_Save, Display_save_confirmation, Save_file, Display_drawing_screen, Draw, Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Erase2, Clear_screen, Display_drawing_screen, Press_Menu, Display_Menu, Press_Save, Display_save_confirmation, Press_Back, Display_drawing_screen, Press_Menu, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Press_Erase2, Clear_screen, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Back, Display_Menu, Press_Color, Display_Choose_Color, Press_Back, Display_drawing_screen, Press_Menu, Display_Menu, Press_Line_Width, Display_Choose_Line_Width, Press_Back, Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Back, Display_drawing_screen, Press_Back";
		String cesOne = "Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Cancel, Display_drawing_screen, Press_Menu, Display_Menu, Press_Clear, Clear_screen, Display_drawing_screen, Press_Menu, Display_Menu, Press_Back, Display_drawing_screen, Press_Menu, Display_Menu, Press_Color, Display_Choose_Color, Display_Set_Color, Change_to_configured_color, Display_drawing_screen, Press_Menu, Display_Menu, Press_Line_Width, Display_Choose_Line_Width, Press_Set_Line_Width, Change_to_configured_width, Display_drawing_screen, Press_Menu, Display_Menu, Press_Save, Display_save_confirmation, Display_insufficient_space, Display_drawing_screen, Press_Menu, Display_Menu, Press_Erase1, Change_color_to_white, Display_drawing_screen, Press_Menu, Display_Menu, Draw, Display_drawing_screen, Press_Menu, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Press_Cancel, Display_Menu, Press_Save, Display_save_confirmation, Save_file, Display_drawing_screen, Draw, Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Erase2, Clear_screen, Display_drawing_screen, Press_Menu, Display_Menu, Press_Save, Display_save_confirmation, Display_drawing_screen, Press_Menu, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Press_Erase2, Clear_screen, Display_Menu, Accelerometer_state_change, Display_clear_confirmation, Back, Display_Menu, Press_Color, Display_Choose_Color, Press_Back, Display_drawing_screen, Press_Menu, Display_Menu, Press_Line_Width, Display_Choose_Line_Width, Press_Back, Display_drawing_screen, Accelerometer_state_change, Display_clear_confirmation, Press_Back, Display_drawing_screen, Press_Back";

		TestCaseUtil.executeTestCase(this, DM8CaseTest.class, cesOne);
	}

	public void testCesTwo() throws Exception {
		String cesTwo = "Display_drawing_screen, Draw, Press_Back";

		TestCaseUtil.executeTestCase(this, DM8CaseTest.class, cesTwo);
	}

	public void Display_drawing_screen() throws Exception {
	}

	public void Accelerometer_state_change() throws Exception {
		TestAccelerationEvent.changeAccelerationState("0", "0", "0");

		solo.sleep(50);

		TestAccelerationEvent.changeAccelerationState("255", "255", "255");
	}

	public void Display_clear_confirmation() throws Exception {
		boolean actualTest = solo.waitForText(solo.getString(R.string.message_erase));

		// assertEquals("Message Clear Confirmation not found", true,
		// actualTest);
	}

	public void Press_Cancel() throws Exception {
		boolean actualTest = solo.waitForText(solo.getString(R.string.message_erase));

		if (actualTest) {
			solo.clickOnButton(solo.getString(R.string.button_cancel));
		}
	}

	public void Press_Menu() throws Exception {
		solo.sleep(5000);

		new Thread(new Runnable() {
			public void run() {
				getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
			}
		}).start();
	}

	public void Display_Menu() throws Exception {
	}

	public void Press_Clear() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_clear));
	}

	public void Clear_screen() throws Exception {
	}

	public void Press_Back() throws Exception {
		solo.goBack();
	}

	public void Press_Color() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_color));
	}

	public void Display_Choose_Color() throws Exception {
		solo.setProgressBar(0, 125);
		solo.setProgressBar(1, 62);
		solo.setProgressBar(2, 187);
		solo.setProgressBar(3, 0);
	}

	public void Display_Set_Color() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_set_color));
	}

	public void Change_to_configured_color() throws Exception {
	}

	public void Press_Line_Width() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_line_width));
	}

	public void Display_Choose_Line_Width() throws Exception {
		solo.setProgressBar(0, 25);
	}

	public void Press_Set_Line_Width() throws Exception {
		solo.clickOnButton(solo.getString(R.string.button_set_line_width));
	}

	public void Change_to_configured_width() throws Exception {
	}

	public void Press_Save() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_save_image));
	}

	public void Display_save_confirmation() throws Exception {
		boolean actualTest = solo.waitForText(solo.getString(R.string.message_saved));

		assertEquals("Message Saved not found", true, actualTest);
	}

	public void Display_insufficient_space() throws Exception {
	}

	public void Press_Erase1() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_erase));
	}

	public void Press_Erase2() throws Exception {
		boolean actualTest = solo.waitForText(solo.getString(R.string.message_erase));

		if (actualTest) {
			solo.clickOnButton(solo.getString(R.string.button_erase));
		}
	}

	public void Change_color_to_white() throws Exception {
	}

	public void Draw() throws Exception {
		solo.drag(60, 220, 80, 300, 10);
	}

	public void Save_file() throws Exception {
	}

	public void Back() throws Exception {
		solo.goBack();
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
