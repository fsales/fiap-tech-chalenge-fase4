package br.com.fsales.nexstream.domain.core.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fsales.nexstream.domain.Mapper;


public record Pagina<T>(List<T> list, long totalElements) {

	public <R> Pagina<R> map(Mapper<? super T, ? extends R> mapper) {
		List<R> mappedList = list == null ? new ArrayList<>()
				: list.stream().map(mapper::apply).collect(Collectors.toList());
		return new Pagina<>(mappedList, totalElements);
	}
}
