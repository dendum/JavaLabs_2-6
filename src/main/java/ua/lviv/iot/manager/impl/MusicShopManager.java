package ua.lviv.iot.manager.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ua.lviv.iot.manager.IMusicShopManager;
import ua.lviv.iot.model.Music;

public class MusicShopManager implements IMusicShopManager {
	private Map<String, List<Music>> content = new HashMap<>();

	@Override
	public List<Music> findByGenreForCD(final String genre) {
		final int maxDuration = 11;
		List<Music> list = new LinkedList<>();
		content.get(genre).forEach(music -> {
			if (music.getDurationInMinutes() < maxDuration) {
				list.add(music);
			}
		});
		return list;
	}

	@Override
	public List<Music> getSortedByIncreasingDuration(final List<Music> list) {
		var lst = list;
		lst.sort(Comparator.comparing(Music::getDurationInMinutes));
		return lst;
	}

	@Override
	public List<Music> getSortedByDecreasingDuration(final List<Music> list) {
		var lst = list;
		lst.sort(Comparator.comparing(
				Music::getDurationInMinutes).reversed());
		return lst;
	}

	@Override
	public List<Music> getSortedByIncreasingSize(final List<Music> list) {
		var lst = list;
		 lst.sort(Comparator.comparing(
				 Music::getSizeInMb));
		return lst;
	}

	@Override
	public List<Music> getSortedByDecreasingSize(final List<Music> list) {
		var lst = list;
		lst.sort(Comparator.comparing(
				Music::getSizeInMb).reversed());
		return lst;
	}

	@Override
	public void addMusic(final Music m) {
		List<Music> lst = content.get(m.getGenre());
		if (lst == null) {
			lst = new LinkedList<>();
		}
		lst.add(m);
		content.put(m.getGenre(), lst);
	}
}
