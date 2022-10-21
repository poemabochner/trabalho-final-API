package br.org.serratec.trabalho.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.serratec.trabalho.domain.Endereco;
import br.org.serratec.trabalho.dto.EnderecoViaCepDTO;

@Service
public class EnderecoService {

	public Endereco buscarCep(String cep) {

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/" + cep + "/json";
		Optional<EnderecoViaCepDTO> enderecoViaCep = Optional
				.ofNullable(restTemplate.getForObject(uri, EnderecoViaCepDTO.class));
		if (enderecoViaCep.get().getCep() != null) {
			String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");
			enderecoViaCep.get().setCep(cepSemTraco);

			Endereco enderecoBanco = new Endereco();

			enderecoBanco.setCep(enderecoViaCep.get().getCep());
			enderecoBanco.setRua(enderecoViaCep.get().getLogradouro());
			enderecoBanco.setBairro(enderecoViaCep.get().getBairro());
			enderecoBanco.setCidade(enderecoViaCep.get().getLocalidade());
			enderecoBanco.setComplemento(enderecoViaCep.get().getComplemento());
			enderecoBanco.setUf(enderecoViaCep.get().getUf());

			return enderecoBanco;
		} else {
			return null;
		}
	}

}
