public class IsLegalIP
{
	public static boolean isIpLegal(String str) {
		if (str.length() < 7 || str.length() > 15) return false;
		if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') return false;
		String[] arr = str.split("\\.");
		if (arr.length != 4) return false;
		for (int i = 0; i < arr.length; i++){
			if (arr[i].length() > 1 && arr[i].charAt(0) == 0) return false;
			for (int j = 0; j < arr[i].length(); j++){
				if (arr[i].charAt(j) < '0' || arr[i].charAt(j) > '9') return false;
			}
			int tmp = Integer.parseInt(arr[i]);
			if (i == 0){
				if (tmp < 1 || tmp > 255) return false;
			}else {
				if (tmp < 0 || tmp > 255) return false;
			}
		}
		return true;
	}
	
	//采用正则表达式
//	public static boolean isIpLegal(String ipStr) {
//		String ipRegEx = "^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))(\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))){3}$";
//		Pattern pattern = Pattern.compile(ipRegEx);
//		Matcher matcher = pattern.matcher(ipStr);
//		if (matcher.matches()) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	public static void main(String[] args){
		//Scanner scanner = new Scanner(System.in);
		//String ipStr = scanner.nextLine();
		String ipStr = "256.255.255.255";
		boolean isIpLegal = isIpLegal(ipStr);
		if(isIpLegal) {
			System.out.println(ipStr + " 合法");
		
		}else{
			System.out.println(ipStr + " 非法");		
		}
	}

}
