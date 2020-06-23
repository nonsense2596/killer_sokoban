# Killer Sokoban

## Leírás:
A szókoban  („raktáros”) egy olyan fejtöro játék, ahol a játékosnak egy felülnézetes labirintusban kell dobozokat tologatnia a helyükre. Esetünkben ez a játék úgynevezett "többjátékos" formájában fog szerepelni, ami azt jelenti, hogy a pályán nem egy, hanem több játékos tologatja a dobozokat körökre osztott formában. A körökre bontott játékmenet lehetové teszi, hogy a játékosok egymást kijátszva, taktikus gondolkodást alkalmazva gyozedelmeskedjenek a többi felett, emellett így a billentyuzet által nyújtott fizikai korlátozás is elkerülheto (nehéz lenne négyen egy billentyuzeten játszani). 

A pálya mérete egy állandó mérettel van megadva amelynek szegélyét egy körbe futó fal elem sorozat reprezentál, benne a pálya elemek viszont véletlenszeruen, procedurálisan vannak generálva. Pálya elemek alatt a falakat, a mezoket, a célmezoket, a ládákat, alap lyukakat, kapcsolókat, az általuk kinyitott lyukakat, és azoknak kapcsolatait, pozícióit, továbbá a játékosokat értjük. Minden pálya elemre szigorú funkcionális megkötések vonatkoznak. 
 
A falak olyan elemek, amelyeken dobozokat áttolni nem lehet, és a játékosok sem képesek átmenni rajtuk, mondhatni ez a pálya elem számít a “legerosebbnek”. Általánosságban elmondható, hogy ha egy játékos mellett valamilyen irányban fal van, akkor az abba az irányba nem léphet. 
 
A mezok olyan elemek, amelyekre a dobozok tolhatók és amelyekre a játékosok is léphetnek. Ezeknek a kapcsolata alkotja a bejárható pályarészt. 
 
A dobozok olyan elemek, amelyek a játékos által tolhatóak, viszont húzni nem lehet oket. Csak olyan irányban mozoghatnak, amilyen irányban a játékos is mozoghat (fel, le, jobbra, balra). A játékos képes arra is, hogy több ládát eltoljon egyszerre: abban az esetben ha a ládák egymás mellett vannak és akad elég hely az eltolásukra. A ládák emellett képesek a lyukakon leesni és megsemmisülni. 
 
A célmezok olyan elemek, amelyekre ha egy dobozt rátolunk, a doboz eltunik. Ekkor az a játékos aki a dobozt rátolta kap 1 db pontot. 
 
A játék egyetlen, felhasználók által direktben irányított eleme a játékos. Ebbol a játékban minimum 2, de akár maximum 4 is lehet. Képessége hogy tologathatja a dobozokat, aktiválhatja a kapcsolókat, mászkálhat a mezokön. Mozgását tekintve csak 4 irányban mozoghat az égtájaknak megfeleloen. Fel, le, jobbra, balra; az átlós mozgás nem engedélyezett. A játékosok egymással szorosabb kapcsolatba nem tudnak lépni, mivel egy mezon egyszerre csak egy játékos lehet. Interakciójuk egyetlen formája az egymással szemben elkövetett szándékos emberölés (amit amúgy a törvény büntet), de ez egy játék, szóval ezt elnézzük. 
 
A kapcsoló egy speciális mezofajta, amelyre ha a játékos rátol egy ládát, megnyit egy lyukat a pálya egy random pontján. Ez akár olyan mezo is lehet amelyen láda vagy egy másik játékos áll (sot akár saját maga is!). Fontos tényezo, hogy a kapcsoló mezo kinézetre nem különbözik a sima mezotol (így izgalmassabb a játékmenet, mert a játékosokat meglepetések érik). Ha a ládát letolják a kapcsolóról akkor a lyuk amit megnyitott bezárul. 
 
A lyukat tartalmazó mezo abban jellegzetes, hogy ami rákerül az beleesik és úgymond megszunik létezni (játékos esetén persze, meghal, nullázódik az ideje). Ilyen mezo létezik alapból is, de kapcsoló által is keletkezhet. 
 
Ez mind vonatkozik a belso falakra, oszlopokra (egy fal elem), ládákra, kapcsolókra, a kapcsolók által kinyitott lyukra, és magukra a játékosokra is. Fontos kitétel, hogy a pályán nincsenek “generált” csapdák (úgy indul a játékos, hogy minden irányban, vagy legalábbis, északon, délen, keleten és nyugaton falak veszik körül. 
 
A játékmenetet tekintve, minden játékosnak fix külön idot adunk (mint a sakkban), ezzel az idovel kell gazdálkodnia a körök alatt. Akinek az ideje lejárt, az többet nem kap lehetoséget a lépésre, ha meghal az ideje automatikusan nullázódik. A játék akkor ér véget ha mindenkinek az ideje lejárt. Ekkor kiértékelodnek a pontok.  A legtöbb ponttal rendelkezo játékos lesz a nyertes. Döntetlenek is kialakulhatnak. A játékosok célja, hogy minél több ládát toljanak a cél mezokre, és így minél több pontot össze tudjanak gyujteni. 


## Projekt setup: 
A képeket a projekt gyökérmappájába kell helyezni, hogy működjenek.
Ha az src mappában vannak a .java fileok, 
akkor az src, a bin mappát, és a .classpath, .project, és más esetleges IDE által generált fileokat tartalmazó mappába.
