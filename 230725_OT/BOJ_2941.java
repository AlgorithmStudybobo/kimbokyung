// 백준 크로아티아 알파벳 2941번
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String str = br.readLine();
String[] strArr = {"c=" , "c-", "dz=", "d-","lj","nj","s=","z="};
		
int ans = 0;
		
for(int i = 0;i<strArr.length;i++) {
	str=str.replace(strArr[i]," ");
}
		
System.out.println(str.length());