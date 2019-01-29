/**
 * 
 */
package camelinaction.jpa.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 305603
 *
 */
@Repository
public interface  OrderJpaRepository  extends CrudRepository<OrderJpa,Integer> {

}
