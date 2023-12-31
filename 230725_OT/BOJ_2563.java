//백준 색종이 2563번
public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] arr = new int[100][100];
		
		int ans = 0;
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for(int a = x;a<x+10;a++) {
            	for(int b = y;b<y+10;b++) {
            		if(arr[a][b]==0) {
            			arr[a][b] = 1;
            			ans++;
            		}
            	}
            }
		}
        System.out.println(ans);
	}