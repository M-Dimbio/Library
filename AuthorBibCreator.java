import java.io.*;

import java.util.Scanner;


/**
 * @author Mohamed Abdul Mohamed
 * Id: 40098785
 * Date: 2019--03-21
 *comp 249
 */
public class AuthorBibCreator {
	
	public static int count = 1;
	public static int countFound = 0;
	public static boolean found = false;
	
	/**
	 * @param sc will create an Article Array 
	 * @return
	 */
	public static String[] arrayOfArticle(Scanner sc) {

		String storage = "";
		String str = "";
		while (sc.hasNextLine()) {

			str = sc.nextLine();
			if (str.length() == 0)
				continue;
			storage += str;

		}
		String[] articleArray = storage.split("@");

		return articleArray;

	}

	/**
	 * @param articleStorage array of article
	 * @param author the author we are looking for
	 * @param pw write inside the file
	 */
	public static void processBibFiles(String[][] articleStorage, String author, PrintWriter[][] pw) {

		String pwauthor, journal, title, year, volume, number, doi, month, pages, realAuthor;
		pwauthor = "";
		
		for (int m = 0; m < articleStorage.length; m++) {
			for (int n = 0; n < articleStorage[m].length; n++) {
				if (articleStorage[m][n].length() == 0) {
					continue;
				}
				String[] authorArray = articleStorage[m][n].split(",");

				if (authorArray[1].contains("author")) {
					pwauthor = "" + authorArray[1];
					
					

					if (pwauthor.contains(author)) 
					{
						found = true;
						countFound++;
						realAuthor = "";
						journal = "";
						title = "";
						year = "";
						volume = "";
						number = "";
						doi = "";
						month = "";
						number = "";
						pages = "";
						number = "";
						for (int i = 0; i < authorArray.length; i++) {
							if (authorArray[i].contains("author"))
								realAuthor = authorArray[i];
							if (authorArray[i].contains("journal"))
								journal = "" + authorArray[i];
							if (authorArray[i].contains("title"))
								title = "" + authorArray[i];
							if (authorArray[i].contains("year"))
								year = "" + authorArray[i];
							if (authorArray[i].contains("volume"))
								volume = "" + authorArray[i];
							if (authorArray[i].contains("doi"))
								doi = "" + authorArray[i];
							if (authorArray[i].contains("month"))
								month = "" + authorArray[i];
							if (authorArray[i].contains("pages"))
								pages = "" + authorArray[i];
							if (authorArray[i].contains("number"))
								number = "" + authorArray[i];
						}
						for (int i = 0; i < 1; i++) {
							for (int j = 0; j < 3; j++) {
								if (j == 0) {
									String tempNumber = "";
									String tempAuthor = "";
									String tempTitle = "";
									String tempJournal = "";
									String tempYear = "";
									String tempMonth = "";
									String tempPages = "";
									String tempVolume = "";
									tempTitle = title.substring(8, title.length() - 1);
									tempAuthor = realAuthor.replaceAll("and", ",");
									tempAuthor = tempAuthor.replace('}', ' ');
									tempAuthor = tempAuthor.substring(9);
									tempJournal = journal;
									tempJournal = journal.replace('}', ' ');
									tempJournal = tempJournal.substring(10);
									tempYear = year.replace('}', ' ');
									tempYear = tempYear.substring(7);

									tempMonth = month.replace('}', ' ');
									tempMonth = tempMonth.substring(8);
									tempPages = pages.replace('}', ' ');
									tempPages = tempPages.substring(8);
									tempVolume = volume.replace('}', ' ');
									tempVolume = tempVolume.substring(9);
									tempNumber = number.replace('}', ' ');
									tempNumber = tempNumber.substring(9);
									tempNumber = tempNumber.trim();
									pw[i][j].print(tempAuthor + ".");
									pw[i][j].flush();
									pw[i][j].print("\"" + tempTitle + "\",");
									pw[i][j].flush();
									pw[i][j].print(tempJournal + ",");
									pw[i][j].flush();
									pw[i][j].print("vol." + tempVolume.toUpperCase() + ",");
									pw[i][j].flush();
									pw[i][j].print("no." + tempNumber + ",");
									pw[i][j].flush();
									pw[i][j].print("p." + tempPages + ",");
									pw[i][j].print(tempMonth + "");
									pw[i][j].flush();
									pw[i][j].print(tempYear.trim() + ".");
									pw[i][j].flush();
									pw[i][j].println();
								} else if (j == 1) {
									String tempNumber = "";
									String tempAuthor = "";
									String tempTitle = "";
									String tempJournal = "";
									String tempYear = "";
									String tempDoi = "";
									String tempPages = "";
									String tempVolume = "";
									tempTitle = title.substring(8, title.length() - 1);
									tempAuthor = realAuthor;
									tempAuthor = tempAuthor.replace('}', ' ');
									String[] STRFINAL = tempAuthor.split("and");
									STRFINAL[0] = STRFINAL[0].substring(9).trim();
									tempAuthor = tempAuthor.substring(9);
									tempJournal = journal;
									tempJournal = journal.replace('}', ' ');
									tempJournal = tempJournal.substring(10);
									tempYear = year.replace('}', ' ');
									tempYear = tempYear.substring(7);
									tempDoi = doi.replace('}', ' ');
									tempDoi = tempDoi.substring(6);
									tempPages = pages.replace('}', ' ');
									tempPages = tempPages.substring(8);
									tempVolume = volume.replace('}', ' ');
									tempVolume = tempVolume.substring(9);
									tempNumber = number.replace('}', ' ');
									tempNumber = tempNumber.substring(9);
									tempNumber = tempNumber.trim();
									pw[i][j].print("[" + count + "] " + STRFINAL[0] + " et al." + tempYear + ".");
									pw[i][j].flush();
									pw[i][j].print(tempTitle.trim() + ".");
									pw[i][j].flush();
									pw[i][j].print(tempJournal.trim() + ".");
									pw[i][j].flush();
									pw[i][j].print(tempVolume.toUpperCase().trim() + ",");
									pw[i][j].flush();
									pw[i][j].print(tempNumber.trim() + "(" + tempYear + "),");
									pw[i][j].flush();
									pw[i][j].print(tempPages.trim() + ".");
									pw[i][j].print("DOI:https://doi.org/" + tempDoi.trim() + ".");
									pw[i][j].flush();
									pw[i][j].println();
									count++;
								} else {
									String tempAuthor = "";
									String tempTitle = "";
									String tempJournal = "";
									String tempYear = "";
									String tempPages = "";
									String tempVolume = "";
									tempTitle = title.substring(8, title.length() - 1);
									tempAuthor = realAuthor.replaceAll("and", "&");
									tempAuthor = tempAuthor.replace('}', ' ');
									tempAuthor = tempAuthor.substring(9);
									tempJournal = journal;
									tempJournal = journal.replace('}', ' ');
									tempJournal = tempJournal.substring(10);
									tempYear = year.replace('}', ' ');
									tempYear = tempYear.substring(7);
									tempPages = pages.replace('}', ' ');
									tempPages = tempPages.substring(8);
									tempVolume = volume.replace('}', ' ');
									tempVolume = tempVolume.substring(9);
									pw[i][j].print(tempAuthor.trim() + ".");
									pw[i][j].flush();
									pw[i][j].print(tempTitle.trim() + ".");
									pw[i][j].flush();
									pw[i][j].print(tempJournal.trim() + ".");
									pw[i][j].flush();
									pw[i][j].print(tempVolume.toUpperCase().trim() + ",");
									pw[i][j].flush();
									pw[i][j].print(tempPages.trim() + ".(" + tempYear.trim() + ")");
									pw[i][j].println();
								}
							}
						}
					}

				}
			}
			
		}

	}

	public static void main(String[] args) {
		String author = "";
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to BibCreator!");
		System.out.print("Please enter the author name you are targeting:");
		author = kb.nextLine();
		File folder = new File("C:\\Users\\moham\\eclipse-workspace\\A3_249\\Assg_3-Needed-Files");
		File[] listOfFiles = null;
		Scanner sc = null;
		int i = 0;
		String[][] articleStorage = null;
		try {

			listOfFiles = folder.listFiles();
			if(folder.exists()==false)
				throw new FileNotFoundException();
			sc = new Scanner(new FileInputStream(listOfFiles[i]));
			articleStorage = new String[listOfFiles.length][];
			for (i = 0; i < listOfFiles.length; i++) {

				sc = new Scanner(new FileInputStream(listOfFiles[i]));
				String temp[] = arrayOfArticle(sc);
				articleStorage[i] = new String[temp.length];
				for (int j = 0; j < temp.length; j++) {
					articleStorage[i][j] = temp[j];

				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file" 
					+ " for reading. Please check if file exists! Program will terminate after closing any opened files.");
			System.exit(0);
		}
		File IEEE = null;
		File ACM = null;
		File NJ = null;
		File IEEEBU = null;
		File ACMBU = null;
		File NJBU = null;
		File IEEEBU1 = null;
		File ACMBU2 = null;
		File NJBU3 = null;
		try {
			IEEE = new File("" + author + "-IEEE.json");
			ACM = new File("" + author + "-ACM.json");
			NJ = new File("" + author + "-NJ.json");
			if (IEEE.exists() || ACM.exists() || NJ.exists()) 
			{
				kb.close();
				throw new FileExistsException();
			}
		} catch (FileExistsException e2) {

			IEEEBU = new File("" + author + "-IEEE-BU.json");
			ACMBU = new File("" + author + "-ACM.-BU.json");
			NJBU = new File("" + author + "-NJ.-BU.json");
			System.out.println("\nThe file already exist with the name:" + IEEE.toString()
					+ "\rFile will be renamed as:" + IEEEBU.toString() + "\n");
			System.out.println("The file already exist with the name:" + ACM.toString() + "\rFile will be renamed as:"
					+ ACMBU.toString() + "\n");
			System.out.println("The file already exist with the name:" + NJ.toString() + "\rFile will be renamed as:"
					+ NJBU.toString());
			if (IEEEBU.exists() || ACMBU.exists() || NJBU.exists()) {
				IEEEBU.delete();
				ACMBU.delete();
				NJBU.delete();
			}
			IEEEBU1 = new File("" + author + "-IEEE-BU.json");
			ACMBU2 = new File("" + author + "-ACM.-BU.json");
			NJBU3 = new File("" + author + "-NJ.-BU.json");
			IEEE.renameTo(IEEEBU1);
			ACM.renameTo(ACMBU2);
			NJ.renameTo(NJBU3);
		}
		PrintWriter[][] pw = new PrintWriter[1][3];
		File[] fileName = new File[3];
		fileName[0] = new File(author + "-IEEE.json");
		fileName[1] = new File(author + "-ACM.json");
		fileName[2] = new File(author + "-NJ.json");
		pw[0][1] = null;
		pw[0][2] = null;
		pw[0][0] = null;
		for (int k = 0; k < 1; k++) {
			for (int j = 0; j < 3; j++)
				try {

					{
						if (j == 0)
							pw[k][j] = new PrintWriter(new FileOutputStream(fileName[j]));
						else if (j == 1)
							pw[k][j] = new PrintWriter(new FileOutputStream(fileName[j]));
						else if (j == 2)
							pw[k][j] = new PrintWriter(new FileOutputStream(fileName[j]));
					}
				} catch (FileNotFoundException e) {
					System.out.println(fileName[j] + " Couldn't open the file ");
					for (int p = 0; p < 3; p++) {
						fileName[j].delete();
					}

					sc.close();
					kb.close();
					System.exit(0);
				}
			processBibFiles(articleStorage, author, pw);
			if (countFound != 0 && found == true) {
				System.out.println("\nA total of " + countFound + " records were found for authors with name:" + author
						+ "\nFiles" + fileName[0].toString() + "," + fileName[1].toString() + "," + fileName[2]);
				System.out
						.println("\nGoodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
				pw[0][0].close();
				pw[0][1].close();
				pw[0][2].close();
				kb.close();
				sc.close();
				System.exit(0);
			} else if (countFound == 0 && found == false) {

				System.out
						.println("\nNo record were for author(s) with name:" + author + "\nNo file has been created.");
				System.out.println("\nGoodbye Hope you enjoyed creating the needed using AuthorBibCreator.");
				pw[0][0].close();
				pw[0][1].close();
				pw[0][2].close();
				kb.close();
				for (int p = 0; p < fileName.length; p++) {
					fileName[p].delete();
				}
				sc.close();
				System.exit(0);
			}
		}
	}
}
