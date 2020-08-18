package com.testML.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.testML.model.DnaAnalysis;
import com.testML.repository.IMutantRepository;
import com.testML.services.IMutantService;

public class MutantService implements IMutantService{

    @Autowired
    private IMutantRepository mutantRepository;

    @Override
    public boolean isMutant(String[] dna) {
        boolean isMutant = false;
        DnaAnalysis analysis = new DnaAnalysis();
        analysis.setDna(dna);
        //validate NxN
        Integer columnN = dna.length;
        for(String row : dna) {
            Integer rowN = row.length();
            if(columnN != rowN) {
                analysis.setIsMutant(isMutant);
                saveAnalysis(analysis);
                return isMutant;
            }
        }
        //validate horizontal sequence
        //row
        for(String row : dna) {
            char[] rowChar = row.toCharArray();
            //column
            for(Integer j = 0; j < columnN-3; j++) {
                Integer countNextEquals = validateNextHor(rowChar,j);
                if(countNextEquals == 3) {
                    isMutant = true;
                    analysis.setIsMutant(isMutant);
                    saveAnalysis(analysis);
                    return isMutant;
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
                    isMutant = true;
                    analysis.setIsMutant(isMutant);
                    saveAnalysis(analysis);
                    return isMutant;
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
                    isMutant = true;
                    analysis.setIsMutant(isMutant);
                    saveAnalysis(analysis);
                    return isMutant;
                }
            }
        }
        analysis.setIsMutant(isMutant);
        saveAnalysis(analysis);
        return isMutant;
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

    private void saveAnalysis(DnaAnalysis analysis) {
        mutantRepository.insert(analysis);
    }

    @Override
    public Object getStats() {
        long mutants = mutantRepository.countByIsMutant(true);
        long humans = mutantRepository.countByIsMutant(false);
        double ratio = ((double) mutants/humans);
        Map<String,Object> stats = new HashMap<String,Object>();
        stats.put("count_mutant_dna", mutants);
        stats.put("count_human_dna", humans);
        stats.put("ratio”", ratio);
        return stats;
    }
}
