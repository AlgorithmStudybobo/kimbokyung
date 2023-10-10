class Solution {
    public int[] solution(String[] wallpaper) {
        int minx = 52,miny = 52;
        int maxx = 0,maxy = 0;
       
        for(int i = 0;i<wallpaper.length;i++){
            for(int j = 0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='.') continue;
                maxx = Math.max(maxx,i);
                maxy = Math.max(maxy,j);
                minx = Math.min(minx,i);
                miny = Math.min(miny,j);
            }
        }
        int[] answer = {minx,miny,maxx+1,maxy+1};
        return answer;
    }
}
