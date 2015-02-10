CREATE OR REPLACE VIEW v_persons AS
	SELECT pers.id AS personid, wn.number AS war_number, 
	pers.first_name AS firstname, pers.sure_name AS surename, pers.second_name AS secondname

	FROM persons pers
	JOIN war_number wn ON pers.war_number = wn.id