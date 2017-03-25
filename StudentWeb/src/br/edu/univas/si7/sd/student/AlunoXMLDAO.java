package br.edu.univas.si7.sd.student;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class AlunoXMLDAO {

	private String filepath;

	public AlunoXMLDAO(String filepath) {
		this.filepath = filepath;
	}

	public Map<String, Aluno> readAlunos() throws Exception {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
		Object obj = decoder.readObject();
		decoder.close();
		return (Map<String, Aluno>) obj;
	}

	public void saveToFile(Aluno aluno) throws Exception {
		Map<String, Aluno> map;
		try {
			map = readAlunos();
		} catch (Exception e) {
			// se deu exception, eu crio um map novo
			map = new HashMap<String, Aluno>();
		}
		map.put(aluno.getIdentifier(), aluno);

		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
		encoder.writeObject(map);
		encoder.close();
	}
}