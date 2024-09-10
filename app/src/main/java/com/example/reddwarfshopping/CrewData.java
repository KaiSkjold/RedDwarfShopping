package com.example.reddwarfshopping;

import java.util.ArrayList;
import java.util.List;

public class CrewData {

    static List<Crew> addCrewMembers() {

        List<Crew> crewList = new ArrayList<Crew>();

        crewList.add(new Crew("David Lister (Sr. & Jr.)", "Dave","Third Technician", "The last human", "I know, I know, I still haven't had a curry.", "The Starbug, later Earth", "https://static.wikia.nocookie.net/reddwarf/images/e/ed/Dave_Lister.jpg/revision/latest?cb=20171103220357"));
        crewList.add(new Crew("Arnold J. Rimmer BSc., SSc.", "Smeghead", "Second Technicican", "Humonoid hologram, later hard-light hologram", "You think I'm a petty minded, bureaucratic nincompoop who delights in enforcing pernickety regulations 'cause he gets some sort of perverse pleasure out of it. And in many ways, you're absolutely damned right. That doesn't alter the fact that the only way we're gonna track down Red Dwarf and get through this in one piece is with a sense of discipline, a sense of purpose, and wherever possible, a sensible haircut.","Io", "https://static.wikia.nocookie.net/reddwarf/images/e/ed/Arnold_J._Rimmer.jpg/revision/latest?cb=20171103220627"));
        crewList.add(new Crew("Cat", "Cat", "Sleeping and eating.x", "Felis sapiens", "I'm gonna eat you, little fishy", "Supply Pipe 28, Red Dwarf", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC_R_lbMRu7heGst5NHG7XThnznvU9lVfiYQ&s"));
        crewList.add(new Crew("Kryten 2X4B 523P, B.S.", "Kryten", "Servant/ Science Officer", "Series 4000 mechanoid", "You are a SMEEEEEEE... HEEEEEEEEEEE... ", "DivaDroid International", "https://static.wikia.nocookie.net/reddwarf/images/b/b7/Krytenseries2.jpg/revision/latest?cb=20070516033727"));
        crewList.add(new Crew("Holly", "Holly", "Red Dwarf computer", "Artificial Intelligence", " Everybody is dead, Dave.", "Holly Room, originally Earth", "https://static.wikia.nocookie.net/reddwarf/images/4/4d/HOLLYMAN.PNG/revision/latest?cb=20080602035457"));
        crewList.add(new Crew("Hilly", "Hilly", "Red Dwarf computer", "Artificial Intelligence", "quote", "Holly Room, originally Earth", "https://static.wikia.nocookie.net/reddwarf/images/a/a2/Obrazovka_hilly01.jpg/revision/latest?cb=20140603014558"));

        return crewList;
    }

}
