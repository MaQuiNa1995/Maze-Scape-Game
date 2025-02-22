package maquina1995.maze.scape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LaberintoService {
	
	public char[][] createMapLv1() {
		return new char[][] {
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', 'E', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#' },
			{ '#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', '#', '#', '#', ' ', '#', ' ', ' ', '#' },
			{ '#', ' ', '#', 'S', '#', ' ', '#', ' ', '#', '#' },
			{ '#', ' ', '#', ' ', '#', '#', '#', ' ', ' ', '#' },
			{ '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#' },
			{ '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};
	}
	
	public char[][] createMapLv2() {
		return new char[][] {
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#' },
			{ '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#' },
			{ '#', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#' },
			{ '#', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#' },
			{ '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#' },
			{ '#', ' ', ' ', '#', ' ', ' ', 'E', '#', 'S', ' ', ' ', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#' },
			{ '#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#' },
			{ '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#' },
			{ '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#' },
			{ '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', '#', '#' },
			{ '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#' },
			{ '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
		};
	}
	
	public char[][] generateFromFile(){
		
		StringBuilder map = new StringBuilder();
		
		int numFiles = 0;
		int numColumns = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader("customMap.map"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	map.append(line).append("\n");
            	numFiles++;
            	numColumns = line.length();
            }
        } catch (IOException e) {
        	log.error(e.getMessage());
        	System.exit(-1);
        }
		
		
        char[][] mapConvertedToArray = new char[numFiles][numColumns];

        int counterColumn = 0;
        int counterFile = 0;
        
        for (String line : map.toString().split("\n")) {
        	for (char character : line.toCharArray()) {
				mapConvertedToArray[counterFile][counterColumn] = character;
				counterColumn++;
        	}
        	counterColumn = 0;
        	counterFile++;
		}
		
		return mapConvertedToArray;
	}
	
}
