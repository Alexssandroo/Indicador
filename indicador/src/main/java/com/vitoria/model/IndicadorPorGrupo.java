package com.vitoria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ind_indicador_grupo")
public class IndicadorPorGrupo implements Serializable{

		private static final long serialVersionUID = 1L;
		private long id;
		private Grupo grupo;
		private Indicador indicador;
		private BigDecimal meta;
		
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		@ManyToOne
		public Grupo getGrupo() {
			return grupo;
		}
		public void setGrupo(Grupo grupo) {
			this.grupo = grupo;
		}
		@ManyToOne
		public Indicador getIndicador() {
			return indicador;
		}
		public void setIndicador(Indicador indicador) {
			this.indicador = indicador;
		}
		public BigDecimal getMeta() {
			return meta;
		}
		public void setMeta(BigDecimal meta) {
			this.meta = meta;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IndicadorPorGrupo other = (IndicadorPorGrupo) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
				
				

}
