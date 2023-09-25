package com.springbatch.jdbccursorreader.reader;

import com.springbatch.jdbccursorreader.exceptions.SkipReaderException;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbccursorreader.dominio.Cliente;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class JdbcCursorReaderConfig {


//	@Bean
//	public JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource")DataSource dataSource) {
//		return new JdbcCursorItemReaderBuilder<Cliente>()
//				.name("jdbcCursorReader")
//				.dataSource(dataSource)
//				.sql("SELECT * from cliente")
//				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
//				.build();
//	}



//	@Bean
//	public JdbcPagingItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource")DataSource dataSource,
//														  PagingQueryProvider pagingQueryProvider) {
//		System.out.println("pulling on database");
//		return new JdbcPagingItemReaderBuilder<Cliente>()
//				.name("jdbcCursorReader")
//				.dataSource(dataSource)
//				.queryProvider(pagingQueryProvider)
//				.pageSize(2)
//				.rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
//				.build();
//
//	}
//
//
//	@Bean
//	public SqlPagingQueryProviderFactoryBean pagingQueryProvider(@Qualifier("appDataSource")DataSource dataSource){
//		SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
//		queryProvider.setDataSource(dataSource);
//		queryProvider.setSelectClause("SELECT *");
//		queryProvider.setFromClause("FROM cliente");
//		queryProvider.setSortKey("email");
//		return  queryProvider;
//
//	}



	@Bean
	public ItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource")DataSource dataSource) {
		System.out.println("buscando dados");
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("skipExceptionReader")
				.dataSource(dataSource)
				.sql("SELECT * from cliente")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<Cliente> rowMapper() {
		return new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int rownNum) throws SQLException {
//				if(resultSet.getString("email").equals("joao2@test.com")){
//				//if(resultSet.getString("nome").equals("Maria")){
//				//if(resultSet.getRow() == 10){
//					throw new SkipReaderException("Deu um erro");
//				}else{
					return clienteRowMapper(resultSet);
				//}
			}

			private Cliente clienteRowMapper(ResultSet resultSet) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setNome(resultSet.getString("nome"));
				cliente.setSobrenome(resultSet.getString("sobrenome"));
				cliente.setIdade(resultSet.getString("idade"));
				cliente.setEmail(resultSet.getString("email"));
				return  cliente;
			}
		};
	}




}
