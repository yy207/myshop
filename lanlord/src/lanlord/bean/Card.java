package lanlord.bean;

public class Card {
	public Card() {
		init();
	}
	//4个数组1-13
	//大王、小王
	String []cards = new String [54];
	 
	 
	public static void main(String[] args) {
		Card card = new Card();
//		for (String string : card.cards) {
//			System.out.println(string);
//		} 
		card.CardInit();
	} 
	 public void CardInit() {
         
         int count = 1;
         //初始化牌
         for (int i = 1; i <= 5; i++) {
                 for (int j = 1; j <= 13; j++) {
                         if ((i == 5) && (j > 2))
                                 break;
                         else {
//                                 cards[count] = new Card(this, i + "-" + j, false);
//                                 cards[count].setLocation(350, 50);
//                                 container.add(card[count]);
//                                 count++;
                        	 System.out.println(i + "-" + j);
                         }
                 }
         }
//         //打乱顺序
//         for(int i=0;i<100;i++){
//                 Random random=new Random();
//                 int a=random.nextInt(54)+1;
//                 int b=random.nextInt(54)+1;
//                 Card k=card[a];
//                 card[a]=card[b];
//                 card[b]=k;
//         }
	 }
}
