package study.problem;

public class Solution {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int skillSize = skill.length();
		String unCheckedSKill = String.format("[^%s]", skill);
		for (String skillTree : skill_trees) {
			String checkSkillTree = skillTree.replaceAll(unCheckedSKill, "");
			if (checkSkillTree.length() < skillSize) {
				String addtionalSkill = skill.substring(checkSkillTree.length());
				checkSkillTree += addtionalSkill;
			}
			if (skill.equals(checkSkillTree)) {
				answer++;
			}
		}
		return answer;
	}
}