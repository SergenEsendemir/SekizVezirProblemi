package Proje;

public class VezirProblemi {
	final int N = 8;
	
    void CozumuGoster(int tahta[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + tahta[i][j]
                                 + " ");
            System.out.println();
        }
    }
    boolean YerlestirilirMi(int tahta[][], int satir, int sutun)
    {
        int i, j;
        
        for (i = 0; i < sutun; i++)
            if (tahta[satir][i] == 1)
                return false;
 
        for (i=satir, j=sutun; i>=0 && j>=0; i--, j--)
            if (tahta[i][j] == 1)
                return false;
 
        for (i=satir, j=sutun; j>=0 && i<N; i++, j--)
            if (tahta[i][j] == 1)
                return false;
 
        return true;
    }
 
    boolean Cozum(int tahta[][], int sutun)
    {
        if (sutun >= N)
            return true;
 
        for (int i = 0; i < N; i++)
        {
            if (YerlestirilirMi(tahta, i, sutun))
            {
                tahta[i][sutun] = 1;
                if (Cozum(tahta, sutun + 1) == true)
                    return true;
                
                tahta[i][sutun] = 0; 
            }
        }
        return false;
    }
    
    boolean ProblemiCoz()
    {
        int tahta[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0}
        };
 
        if (Cozum(tahta, 0) == false)
        {
            System.out.print("Çözüm Bulunamadý");
            return false;
        }
 
        CozumuGoster(tahta);
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VezirProblemi Vezir = new VezirProblemi();
        Vezir.ProblemiCoz();
	}

}
