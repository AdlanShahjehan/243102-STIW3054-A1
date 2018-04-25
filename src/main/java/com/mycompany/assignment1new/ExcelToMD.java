package com.mycompany.assignment1new;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToMD {

    Writer writer = null;

    boolean test = true;

    public void readFile() throws IOException, InvalidFormatException {
        createFile();

        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\ROG_PC\\Desktop\\practicumstudent.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        writer.write("# Asignment 1 STIW3054 A172 - 243102\n\n");
        writer.write("## STIX 3912 Practicum\n\n");
        writer.write("### `U5a (BSc IT)`\n\n");

        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t | \t");
                writer.write(cellValue + " | ");
            }
            System.out.println();
            writer.write("\n");
            createTableLine();
        }
        closeFile();

        PushGithub github = new PushGithub();
        github.runGit();
    }

    public void createFile() throws IOException {
        File file = new File("C:/Users/ROG_PC/243102-STIW3054-A172-A1.wiki/Markdown.md");
        writer = new BufferedWriter(new FileWriter(file));
    }

    public void createTableLine() throws IOException {

        if (test == true) {
            writer.write(":--:|:--:|--|-- \n");
            test = false;
        }
    }

    public void closeFile() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
