#include <iostream>
#include <fstream>
#include <string>

int main() {
	const std::string fullPath = "instrukcje.txt"; // wczytywanie danych z pliku
	std::ifstream file(fullPath.c_str());
	if (!file.good()) {
		file.close();
		return 0;
	}

	const int NumberOfLine = 2000; // została użyta stała ponieważ w zadaniu została określona konkretna ilośc wierszy tj 2000
	int odp1 = 0, dlugosc = 0, maksDlugosc = 0;
	std::string s;
	std::string prev = "", sMaks, napis = "";
	char c; // np 'A' = 65

	int alfabet[26]; // Tworzymy tablice która będzie przechowywała litery z angielskiego alfabetu
	for (int i = 0; i < 26; i++) //Zerujemy tablice alfabet
		alfabet[i] = 0;

	for (int nr = 0; nr < NumberOfLine; nr++) { // pętla po tylu liniach ile chcemy określając parametr NumberOfLine
		file >> s >> c;
		switch (s[0])
		{
		case 'D': //DOPISZ
			odp1++;
			alfabet[c - 65]++;
			napis += c;
			break;

		case 'U': //USUN
			odp1--;
			napis.resize(napis.size() - 1);
			break;

		case 'Z': //ZAMIEN
			napis[napis.size() - 1] = c;
			break;

		case 'P': //PRZESUN
			//size_t - służy do szukania w stringu
			size_t gdzie = napis.find(c);
			if (gdzie != std::string::npos) //gdy w stringu s występuje c to wtedy
			{							   // gdzie ma nie robić nic
				if (napis[gdzie] == 'Z')
					napis[gdzie] = 'A';
				else napis[gdzie]++;
			}

			break;
		}//switch

		//zad 2
		if (s == prev) {  //jeżeli bieżaca instrukcja jest taka sama jak poprzednia
			dlugosc++; //zwiększamy długość rozpatrywanego podciągu
		}
		else
		{
			if (dlugosc > maksDlugosc) { // jeżeli to co się do tej pory nazbierało prezkracza dotychczasowy podciąg to
				maksDlugosc = dlugosc;	//to mamy nową wartość którą zaczynamy liczyć od nowa
				sMaks = prev;			//
			}
			dlugosc = 1;
			prev = s;				// bierzące s staje się innym s np DOPISZ staje się USUN
		}
	}//for

	if (dlugosc > maksDlugosc) {  // jeżeli najdłuższy ciąg znajdował by się na końcu to wtedy
		maksDlugosc = dlugosc;	  // else powyżej nie ma szansy się wykonac wiec musimy dac również warunek
		sMaks = prev;			  // poza pętlą
	}

	int maksC = 0;
	for (int i = 1; i < 26; i++)
	{
		if (alfabet[i] > alfabet[maksC])
		{
			maksC = i;
		}
	}

	std::cout << "zadanie 4.1 , dlugosc napisu =  " << odp1 << std::endl;
	std::cout << "zadanie 4.2 , " << sMaks << " : " << maksDlugosc << std::endl;
	std::cout << "zadanie 4.3 , litera: " << char(maksC + 65) << ", dopisana: " << alfabet[maksC] << " razy" << std::endl;
	std::cout << "zadanie 4.4 , " << napis << std::endl;

	file.close();
	return 0;
}