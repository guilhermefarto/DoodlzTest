package com.deitel.doodlz.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import com.deitel.doodlz.Doodlz;
import com.deitel.doodlz.R;
import com.deitel.doodlz.test.util.TestAccelerationEvent;
import com.deitel.doodlz.test.util.TestCaseUtil;
import com.robotium.solo.Solo;

public class DM1CaseTest extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	@SuppressWarnings("unchecked")
	public DM1CaseTest() {
		super(Doodlz.class);
	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testCesOne() throws Exception {
		String cesOne = "Initialize_application, Press_Menu_Screen, Select_Erase, Draw_in_screen, Press_Menu_Screen, Select_Line_Width, Select_the_line_width_and_press_Set_Line_Width, Draw_in_screen, Press_Menu_Screen, Select_Color, Select_the_color_and_press_Set_Color, Draw_in_screen, Shake_the_screen, Question_Erase_the_drawing, Draw_in_screen, Press_Back";

		TestCaseUtil.executeTestCase(this, DM1CaseTest.class, cesOne);
	}

	public void testCesTwo() throws Exception {
		String cesTwo = "Initialize_application, Draw_in_screen, Press_Menu_Screen, Select_Clear, Draw_in_screen, Press_Menu_Screen, Select_Save_Image, Bug_Close_application";

		TestCaseUtil.executeTestCase(this, DM1CaseTest.class, cesTwo);
	}

	public void testCesThree() throws Exception {
		String cesThree = "Initialize_application, Press_Menu_Screen, Press_Back";

		TestCaseUtil.executeTestCase(this, DM1CaseTest.class, cesThree);
	}

	public void Initialize_application() throws Exception {
	}

	public void Press_Menu_Screen() throws Exception {
		new Thread(new Runnable() {
			public void run() {
				getInstrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_MENU);
			}
		}).start();
	}

	public void Select_Erase() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_erase));
	}

	public void Draw_in_screen() throws Exception {
		solo.drag(60, 220, 80, 300, 10);
	}

	public void Select_Line_Width() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_line_width));
	}

	public void Select_the_line_width_and_press_Set_Line_Width() throws Exception {
		solo.setProgressBar(0, 25);

		solo.clickOnButton(solo.getString(R.string.button_set_line_width));
	}

	public void Select_Color() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_color));
	}

	public void Select_the_color_and_press_Set_Color() throws Exception {
		solo.setProgressBar(0, 125);
		solo.setProgressBar(1, 62);
		solo.setProgressBar(2, 187);
		solo.setProgressBar(3, 0);

		solo.clickOnButton(solo.getString(R.string.button_set_color));
	}

	public void Shake_the_screen() throws Exception {
		TestAccelerationEvent.changeAccelerationState("0", "0", "0");

		solo.sleep(50);

		TestAccelerationEvent.changeAccelerationState("255", "255", "255");
	}

	public void Question_Erase_the_drawing() throws Exception {
		boolean actualTest = solo.waitForText(solo.getString(R.string.message_erase));

		if (actualTest) {
			solo.clickOnButton(solo.getString(R.string.button_erase));
		}
	}

	public void Press_Back() throws Exception {
		solo.goBack();
	}

	public void Select_Clear() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_clear));
	}

	public void Select_Save_Image() throws Exception {
		solo.clickOnMenuItem(solo.getString(R.string.menuitem_save_image));

		boolean actualTest = solo.waitForText(solo.getString(R.string.message_saved));

		assertEquals("Message Saved not found", true, actualTest);
	}

	public void Bug_Close_application() throws Exception {
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
