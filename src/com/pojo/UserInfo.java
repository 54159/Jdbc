package com.pojo;

public class UserInfo {
	// �������� ʹ���շ���������
		private String userID;
		private String userName;
		private String userPass;
		private String realName;
		private Integer userAge;

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPass() {
			return userPass;
		}

		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}

		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		public int getUserAge() {
			return userAge;
		}

		@Override
		public String toString() {
			return "UserInfo [userID=" + userID + ", userName=" + userName + ", userPass=" + userPass + ", realName="
					+ realName + ", userAge=" + userAge + "]";
		}

		public void setUserAge(Integer userAge) {
			this.userAge = userAge;
		}

		public UserInfo(String userID, String userName, String userPass, String realName, Integer userAge) {
			super();
			this.userID = userID;
			this.userName = userName;
			this.userPass = userPass;
			this.realName = realName;
			this.userAge = userAge;
		}

		public UserInfo() {
			super();
		}

}
