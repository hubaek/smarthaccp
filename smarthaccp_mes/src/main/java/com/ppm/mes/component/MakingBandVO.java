package com.ppm.mes.component;

import com.chequer.axboot.core.vo.BaseVO;

import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@NoArgsConstructor
public class MakingBandVO extends BaseVO {
	private int startRow;
	private int endRow;
	private int startCell;
	private int endCell;
	

	
	public static MakingBandVO of(int startRow,int endRow,int startCell,int endCell) {
		MakingBandVO band = new MakingBandVO();
		band.setStartRow(startRow);
		band.setEndRow(endRow);
		band.setStartCell(startCell);
		band.setEndCell(endCell);
        return band;
    }
	
}