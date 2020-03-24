package let_back;

import java.awt.event.*;
import javax.swing.*;

class CalculatorListener implements ActionListener {
   JLabel jlbResult1, jlbResult2;
   String result="";
   String result1="";
   String result2="";
   String number[] = {" ", " ", " "};   
   
	@Override
	public void actionPerformed(ActionEvent e) {
		String txtButton = e.getActionCommand();		
		if (txtButton.equals("1") || txtButton.equals("2") || txtButton.equals("3") || txtButton.equals("4")
				|| txtButton.equals("5") || txtButton.equals("6") || txtButton.equals("7") || txtButton.equals("8")
				|| txtButton.equals("9")) {
			if (result2.equals("0")) {
				result2 = "";
			}
			result2 += txtButton;
			jlbResult2.setText(result2);
		} else if (txtButton.equals("←")) {
			int len = jlbResult2.getText().length();
			if (len == 1) {
				result2 = "";
				jlbResult2.setText("0");
			} else {
				if (!"".equals(result2)) {
					result2 = result2.substring(0, len - 1);
					jlbResult2.setText(result2);
				}
			}
		} else if (txtButton.equals("CE")) {
			result2 = "";
			result = "";
			jlbResult2.setText("0");
			number[0] = "0";
		} else if (txtButton.equals("C")) {
			result = "";
			result1 = "";
			result2 = "";
			jlbResult1.setText("");
			jlbResult2.setText("0");
			number[0] = " ";
			number[1] = " ";
			number[2] = " ";
		} else if (txtButton.equals("0") || txtButton.equals("00")) {
			if (!("".equals(result2))) {
				if (!"0".equals(result2)) {
					result2 += txtButton;
					jlbResult2.setText(result2);
				}
			} else {
				result2 = "0";
			}
		} else if (txtButton.equals(".")) {
			if ("".equals(result2)) {
				result2 = "0" + txtButton;
			} else {
				if (result2.indexOf(".") == -1) {
					result2 += txtButton;
				}
			}
			jlbResult2.setText(result2);
		} else if (txtButton.equals("=")) {
			if (!"".equals(result2)) {
				number[2] = result2;
			}
			if ("".equals(result1)) {
				if (!number[1].equals(" ")) {
					result = Cal();
					if ("0으로 나눌 수 없습니다.".equals(result)) {
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					} else {
						number[0] = result;
						jlbResult2.setText(result);
					}
				}
				jlbResult1.setText(result1);
			} else {
				if (" ".equals(number[2])) {
					number[2] = result2;
				}
				result = number[0];

				if ("0으로 나눌 수 없습니다.".equals(result)) {
					jlbResult2.setText(result);
					result = "";
					result1 = "";
					result2 = "";
					number[0] = " ";
					number[1] = " ";
					number[2] = " ";
				} else {
					result = Cal();

					if (!"0으로 나눌 수 없습니다.".equals(result)) {
						result1 = "";
						number[0] = result;
						jlbResult2.setText(result);
						jlbResult1.setText(result1);
						result2 = "";
					} else {
						jlbResult2.setText("0으로 나눌 수 없습니다.");
						jlbResult1.setText("");
						result = "";
						result1 = "";
						result2 = "";
						number[0] = " ";
						number[1] = " ";
						number[2] = " ";
					}
					System.out.println("?");
				}
			}
		} else if (txtButton.equals("/") || txtButton.equals("*") || txtButton.equals("-") || txtButton.equals("+")) {
			if ("".equals(result1)) {
				if ("".equals(result2)) {
					if ("".equals(result)) {
						result1 = "0" + txtButton;
						number[0] = "0";
					} else {
						result1 = result + txtButton;
					}
				} else {
					if (!"".equals(result)) {
						result1 = result + txtButton;
					}
					result1 = result2 + txtButton;
					number[0] = result2;
				}
				number[1] = txtButton;
			} else {
				if ("".equals(result2)) {
					result1 = result1.substring(0, result1.length() - 1) + txtButton;
					number[1] = txtButton;
				} else {
					result1 += result2 + txtButton;
					number[2] = result2;
					result = Cal();
					number[1] = txtButton;
					jlbResult2.setText(result);
					number[0] = result;
				}
			}
			if (number[1].equals("/") && (number[2].equals(" 0") || number[2].equals("0"))) {

			} else {
				result2 = "";
				jlbResult1.setText(result1);
			}

		}
	}

	public String Cal() {
		String num = "";
		String testNum1 = "";
		String testNum2 = "";

		if (number[0].indexOf(".") != -1) {
			int index1 = number[0].indexOf(".");

			testNum1 = number[0].substring(index1, number[0].length());

			if (testNum1.replaceAll("0", "").equals(".")) {
				number[0] = number[0].substring(0, index1);
			}
		}

		if (number[2].indexOf(".") != -1) {
			int index2 = number[2].indexOf(".");

			testNum2 = number[2].substring(index2, number[2].length());

			if (testNum2.replaceAll("0", "").equals(".")) {
				number[2] = number[2].substring(0, index2);
			}
		}
		if (number[1].equals("*")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) * Double.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) * Long.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("+")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) + Double.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) + Long.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("-")) {
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) - Double.parseDouble(number[2])) + "";
			} else {
				if ("".equals(number[2])) {
					num = result2;
				} else {
					if (!"".equals(result)) {
						number[0] = result;
					}
					num = (Long.parseLong(number[0]) - Long.parseLong(number[2])) + "";
					result = num;
					number[0] = result;
				}
			}
		} else if (number[1].equals("/")) {
			number[2].trim();
			if (number[0].indexOf(".") != -1 || number[2].indexOf(".") != -1) {
				num = (Double.parseDouble(number[0]) / Double.parseDouble(number[2])) + "";
			} else {
				if (number[2].equals("0")) {
					num = "0으로 나눌 수 없습니다.";
					result2 = "";
				} else {
					if ("".equals(number[2])) {
						num = result2;
					} else {
						if (!"".equals(result)) {
							number[0] = result;
						}
						num = (Double.parseDouble(number[0]) / Double.parseDouble(number[2])) + "";

						if (num.indexOf(".") != -1) {
							int index3 = num.indexOf(".");
							String testNum3 = num.substring(index3, num.length());
							if (testNum3.replaceAll("0", "").equals(".")) {
								num = num.substring(0, index3);
							}
						}
						result = num;
						number[0] = result;
					}
				}
			}
		}
		return num;
	}
}
