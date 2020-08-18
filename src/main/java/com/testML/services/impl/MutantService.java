package com.testML.services.impl;

import com.testML.services.IMutantService;

public class MutantService implements IMutantService{

    @Override
    public boolean isMutant(String[] dna) {
        //validate NxN
        Integer columnN = dna.length;
        for(String row : dna) {
            Integer rowN = row.length();
            if(columnN != rowN)
                return false;
        }
        //validate horizontal sequence
        //row
        for(String row : dna) {
            char[] rowChar = row.toCharArray();
            //column
            for(Integer j = 0; j < columnN-3; j++) {
                Integer countNextEquals = validateNextHor(rowChar,j);
                if(countNextEquals == 3) {
                    return true;
                } else {
                    j = j + countNextEquals;
                }
            }
        }
        //validate vertical sequence
        //column
        for(Integer i = 0; i < columnN; i++) {
            //row
            for(Integer j = 0; j < columnN-3; j++) {
                Integer countNextEquals = validateNextVer(dna,i,j);
                if(countNextEquals == 3) {
                    return true;
                } else {
                    j = j + countNextEquals;
                }
            }
        }
        //validate diagonal sequence
        //column
        for(Integer i = 0; i < columnN-3; i++) {
            //row
            for(Integer j = 0; j < columnN-3; j++) {
                Integer countNextEquals = validateNextDia(dna,i,j);
                if(countNextEquals == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private Integer validateNextHor(char[] rowChar, Integer baseIndex) {
        Integer count = 0;
        for(Integer k = baseIndex; count < 3; k++) {
            if(rowChar[k] == rowChar[k+1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private Integer validateNextVer(String[] dna, Integer columnIndex, Integer rowIndex) {
        Integer count = 0;
        for(Integer k = rowIndex; count < 3; k++) {
            if(dna[k].toCharArray()[columnIndex] == dna[k+1].toCharArray()[columnIndex]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private Integer validateNextDia(String[] dna, Integer columnIndex, Integer rowIndex) {
        Integer count = 0;
        for(Integer k = rowIndex, h = columnIndex; count < 3; k++, h++) {
            if(dna[k].toCharArray()[h] == dna[k+1].toCharArray()[h+1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
