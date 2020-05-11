/**
 * IUserCustomRepository.java
 *  
 */
package com.wms.respository.custom;

/**
 * @author chirag
 * @type IUserCustomRepository
 * @since May 11, 2020
 */

public interface IUserCustomRepository {

	/**
	 * @param id
	 * @return
	 */
	boolean removeById(String id);

}
