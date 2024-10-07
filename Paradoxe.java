import java.util.Random;

public class Paradoxe {
	
	/* on met dans chaque enveloppe soit le montant soit le double du montant de manière aléatoire */
	public static int[] remplirLesEnveloppes(int montant) {
		
		int [] tabEnveloppes = new int [2];
		int firstEnveloppe = 0;
		int secondEnveloppe = 0;
		
		Random random = new Random();		
		int alea = random.nextInt(2);
		
		if (alea == 1){ 
			firstEnveloppe = montant * 2; 
			secondEnveloppe = montant;
		} else {
			firstEnveloppe = montant; 
			secondEnveloppe = montant * 2;
		}
		
		tabEnveloppes[0] = firstEnveloppe;
		tabEnveloppes[1] = secondEnveloppe;
		
		return tabEnveloppes;
	}
	
	/* on fait appel à la méthode 100 fois et on regarde à chaque fois quelle enveloppe possède le plus gros montant */
	public static int remplirLesEnveloppes100Fois(int argent) {
		
		int firstEnveloppeLarger = 0;
		
		for (int i = 0; i < 100; i++) {		
			int [] res = remplirLesEnveloppes(10);
			if (res[0] > res[1])
				firstEnveloppeLarger++;	
		}
		return firstEnveloppeLarger;
	}
	
	/* on affiche combien de fois chaque enveloppe a eu le plus gros montant */
	public static void calculStatistique (int firstEnveloppeLarger) {
		
		int secondEnveloppeLarger = 100 - firstEnveloppeLarger;
		
		System.out.println(	"Sur 100 essais l'enveloppe A a contenu la plus grosse somme d'argent " + firstEnveloppeLarger + 
				" fois et l'enveloppe B " + secondEnveloppeLarger );
		
		
	}
	
	public static void main (String []args) {
		
		for (int i = 0; i < 10; i++) {
			calculStatistique(remplirLesEnveloppes100Fois(10));
		}	
	}
}
