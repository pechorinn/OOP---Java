package musicinstruments.demo;
/*
 * Да се направи програма, която симулира работата на магазин за музикални инструменти.
Съществуват различно видове музикални инструменти в каталога на магазина:
• струнни (цигулка, виола, контрабас, арфа, китара, гъдулка, ...)
• ударни (барабани, тарамбука, тъпан, дайре, ...)
• духови (тромпет, тромбон, туба, флейта, кларинет, ...)
• клавишни (орган, пиано, акордеон, ...)
• електронни (синтезатор, бас-китара, електрическа цигулка, ...)
Всеки музикален инструмент има наименование, цена и наличност в магазина.
Магазинът има каса, в която има пари в наличност.
В магазинът могат да се извършват следните операции:
1. продажба на инструмент (по наименование и бройка). Продажбата увеличава парите в
наличност на магазина и премахва броят продадени инструменти от наличните в
магазина. Продажбата може да се осъществи само ако има достатъчно налични
бройки от инструмента. При невъзможност да се продадат инструментите, да се върне
подходящо съобщение към потребителя.
2. Приемане на нови инструменти за продажба в магазина (наименование и бройка).
3. Изготвяне на каталог на инструментите в магазина:
◦ списък с инструментите, подредени по вид
◦ списък с инструментите, подредени по наименование в азбучен ред
◦ списък с инструментите, подредени по цена (възможност за избор на възходящо
или низходящо подреждане)
◦ списък с инструментите, които са налични в магазина в момента
4. Изготвяне на справки за работата на магазина
◦ генериране на списък с продадени инструменти, подредени по брой продажби
◦ генериране на обща сума, получена при продажба на инструменти
◦ актуална информация за най-продаван инструмент (като бройка спрямо
останалите)
◦ актуална информация за най-непродаван инструмент
◦ актуална информация за вид инструменти, които най-много се харчат (с най-
голяма обща бройка продадени от този вид)
◦ актуална информация за вид инструменти, от които магазинът има най-голям
приход (с най-голяма обща сума от продажбите)

 */

import musicinstruments.Instrument;
import musicinstruments.Shop;
import musicinstruments.Instrument.Duhovi;
import musicinstruments.Instrument.Electronni;
import musicinstruments.Instrument.Klavishni;
import musicinstruments.Instrument.Strunni;
import musicinstruments.Instrument.Udarni;

public class Demo {

	public static void main(String[] args) {

		Shop shop = new Shop("Sofia Mall", 100);

		shop.sellInstrument(Instrument.Duhovi.FLEITA, 5);
		shop.sellInstrument(Instrument.Duhovi.KLARINET, 3);
		shop.sellInstrument(Instrument.Duhovi.TUBA, 7);
		shop.sellInstrument(Instrument.Strunni.ARFA, 1);
		shop.sellInstrument(Instrument.Duhovi.TROMPET, 15);
		shop.sellInstrument(Instrument.Duhovi.KLARINET, 6);
		shop.sellInstrument(Instrument.Udarni.BARABAN, 2);
		shop.sellInstrument(Instrument.Klavishni.AKORDEON, 4);
		shop.sellInstrument(Instrument.Klavishni.PIANO, 10);
		shop.sellInstrument(Instrument.Klavishni.ORGAN, 11);
		
		shop.addNewInstrumentsToTheShop(Instrument.Electronni.BAS_KITARA, 10);
		shop.printCatalogByCategory();
        shop.printCatalogInAlphabeticalOrder();
        shop.printCatalogByPriceAcsending();
        shop.printCatalogByPriceDescending();
        shop.printAvailableInstruments();
        shop.printInstrumentsAccordingToNumberOfSales();
        shop.printIncomeFromSales();
        shop.printTheMostSellingInstrument();
        shop.printTheLeastSellingInstrument();
        shop.printInfoAboutMostSellingInstrumentType();
        shop.printInfoAboutMostIncomeGeneratingInstrumentType();
	}

}
