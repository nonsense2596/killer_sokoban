Le�r�s:
A sz�koban  (�rakt�ros�) egy olyan fejt�ro j�t�k, ahol a j�t�kosnak egy fel�ln�zetes labirintusban kell dobozokat tologatnia a hely�kre. Eset�nkben ez a j�t�k �gynevezett "t�bbj�t�kos" form�j�ban fog szerepelni, ami azt jelenti, hogy a p�ly�n nem egy, hanem t�bb j�t�kos tologatja a dobozokat k�r�kre osztott form�ban. A k�r�kre bontott j�t�kmenet lehetov� teszi, hogy a j�t�kosok egym�st kij�tszva, taktikus gondolkod�st alkalmazva gyozedelmeskedjenek a t�bbi felett, emellett �gy a billentyuzet �ltal ny�jtott fizikai korl�toz�s is elker�lheto (neh�z lenne n�gyen egy billentyuzeten j�tszani). 

A p�lya m�rete egy �lland� m�rettel van megadva amelynek szeg�ly�t egy k�rbe fut� fal elem sorozat reprezent�l, benne a p�lya elemek viszont v�letlenszeruen, procedur�lisan vannak gener�lva. P�lya elemek alatt a falakat, a mezoket, a c�lmezoket, a l�d�kat, alap lyukakat, kapcsol�kat, az �ltaluk kinyitott lyukakat, �s azoknak kapcsolatait, poz�ci�it, tov�bb� a j�t�kosokat �rtj�k. Minden p�lya elemre szigor� funkcion�lis megk�t�sek vonatkoznak. 
 
A falak olyan elemek, amelyeken dobozokat �ttolni nem lehet, �s a j�t�kosok sem k�pesek �tmenni rajtuk, mondhatni ez a p�lya elem sz�m�t a �legerosebbnek�. �ltal�noss�gban 
Szoftver projekt laborat�rium  Trolibusz 

elmondhat�, hogy ha egy j�t�kos mellett valamilyen ir�nyban fal van, akkor az abba az ir�nyba nem l�phet. 
 
A mezok olyan elemek, amelyekre a dobozok tolhat�k �s amelyekre a j�t�kosok is l�phetnek. Ezeknek a kapcsolata alkotja a bej�rhat� p�lyar�szt. 
 
A dobozok olyan elemek, amelyek a j�t�kos �ltal tolhat�ak, viszont h�zni nem lehet oket. Csak olyan ir�nyban mozoghatnak, amilyen ir�nyban a j�t�kos is mozoghat (fel, le, jobbra, balra). A j�t�kos k�pes arra is, hogy t�bb l�d�t eltoljon egyszerre: abban az esetben ha a l�d�k egym�s mellett vannak �s akad el�g hely az eltol�sukra. A l�d�k emellett k�pesek a lyukakon leesni �s megsemmis�lni. 
 
A c�lmezok olyan elemek, amelyekre ha egy dobozt r�tolunk, a doboz eltunik. Ekkor az a j�t�kos aki a dobozt r�tolta kap 1 db pontot. 
 
A j�t�k egyetlen, felhaszn�l�k �ltal direktben ir�ny�tott eleme a j�t�kos. Ebbol a j�t�kban minimum 2, de ak�r maximum 4 is lehet. K�pess�ge hogy tologathatja a dobozokat, aktiv�lhatja a kapcsol�kat, m�szk�lhat a mezok�n. Mozg�s�t tekintve csak 4 ir�nyban mozoghat az �gt�jaknak megfeleloen. Fel, le, jobbra, balra; az �tl�s mozg�s nem enged�lyezett. A j�t�kosok egym�ssal szorosabb kapcsolatba nem tudnak l�pni, mivel egy mezon egyszerre csak egy j�t�kos lehet. Interakci�juk egyetlen form�ja az egym�ssal szemben elk�vetett sz�nd�kos ember�l�s (amit am�gy a t�rv�ny b�ntet), de ez egy j�t�k, sz�val ezt eln�zz�k. 
 
A kapcsol� egy speci�lis mezofajta, amelyre ha a j�t�kos r�tol egy l�d�t, megnyit egy lyukat a p�lya egy random pontj�n. Ez ak�r olyan mezo is lehet amelyen l�da vagy egy m�sik j�t�kos �ll (sot ak�r saj�t maga is!). Fontos t�nyezo, hogy a kapcsol� mezo kin�zetre nem k�l�nb�zik a sima mezotol (�gy izgalmassabb a j�t�kmenet, mert a j�t�kosokat meglepet�sek �rik). Ha a l�d�t letolj�k a kapcsol�r�l akkor a lyuk amit megnyitott bez�rul. 
 
A lyukat tartalmaz� mezo abban jellegzetes, hogy ami r�ker�l az beleesik �s �gymond megszunik l�tezni (j�t�kos eset�n persze, meghal, null�z�dik az ideje). Ilyen mezo l�tezik alapb�l is, de kapcsol� �ltal is keletkezhet. 
 
Ez mind vonatkozik a belso falakra, oszlopokra (egy fal elem), l�d�kra, kapcsol�kra, a kapcsol�k �ltal kinyitott lyukra, �s magukra a j�t�kosokra is. Fontos kit�tel, hogy a p�ly�n nincsenek �gener�lt� csapd�k (�gy indul a j�t�kos, hogy minden ir�nyban, vagy legal�bbis, �szakon, d�len, keleten �s nyugaton falak veszik k�r�l. 
 
A j�t�kmenetet tekintve, minden j�t�kosnak fix k�l�n idot adunk (mint a sakkban), ezzel az idovel kell gazd�lkodnia a k�r�k alatt. Akinek az ideje lej�rt, az t�bbet nem kap lehetos�get a l�p�sre, ha meghal az ideje automatikusan null�z�dik. A j�t�k akkor �r v�get ha mindenkinek az ideje lej�rt. Ekkor ki�rt�kelodnek a pontok.  A legt�bb ponttal rendelkezo j�t�kos lesz a nyertes. D�ntetlenek is kialakulhatnak. A j�t�kosok c�lja, hogy min�l t�bb l�d�t toljanak a c�l mezokre, �s �gy min�l t�bb pontot �ssze tudjanak gyujteni. 


A k�peket a projekt gy�k�rmapp�j�ba kell helyezni, hogy m�k�djenek.
Ha az src mapp�ban vannak a .java fileok, 
akkor az src, a bin mapp�t, �s a .classpath, .project fileokat tartalmaz� mapp�ba.