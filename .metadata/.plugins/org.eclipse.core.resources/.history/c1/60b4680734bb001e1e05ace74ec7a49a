package View;

import java.util.Scanner;

import Model.PetDAO;
import Model.PetDTO;
import Model.UserDAO;
import Model.UserDTO;

public class GameMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			ConsoleClear();
			System.out.println("========== 메인 메뉴 ==========");
			System.out.println("[0]게임종료 [1]회원가입 [2]로그인");
			int input = sc.nextInt();

			if (input == 1) { // 회원가입
				ConsoleClear();
				System.out.println("========== 회원가입 ==========");
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				UserDAO userDao = new UserDAO();
				UserDTO userDto = new UserDTO(id, pw);
				int row = userDao.join(userDto);

				if (row > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패..");
				}

			} else if (input == 2) { // 로그인
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				UserDAO userDao = new UserDAO();
				UserDTO userDto = userDao.login(id, pw);

				if (userDto != null) {
					ConsoleClear();
					System.out.println("========== 게임 접속 ==========");
					System.out.println("개냥치 게임에 들어오신걸 환영합니다.");
					PetDAO petDao = new PetDAO();
					PetDTO petDto = userDao.getPetInfo(userDto.getId());

					if (petDto == null) {
						while (true) {
							ConsoleClear();
							System.out.println("========== 동물 종류 선택 ==========");
							System.out.println("[1]고양이 [2]강아지");
							int choice = sc.nextInt();
							System.out.println("========== 동물 이름 짓기 ==========");
							String petName = sc.next();

							if (choice == 1) {
								String str = "고양이";
								// 동물의 종류를 데이터베이스에 전달해주는 메소드 작성
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름 또는 종류를 다시 지어주세요.");
									continue;
								}
								break;
							} else if (choice == 2) {
								String str = "강아지";
								int row = userDao.decideType(petName, str, userDto.getId());
								if (row <= 0) {
									System.out.println("이름 또는 종류를 다시 지어주세요.");
									continue;
								}
								break;
							} else {
								System.out.println("번호를 다시 선택해주세요.");
							}

						}
					}

					if (petDto != null) {

						String name = petDto.getName();
						String spec = petDto.getSpec();
						int hp = petDto.getHp();
						int fullness = petDto.getFullness();
						int love = petDto.getLove();
						int money = petDto.getMoney();
						boolean supply1 = petDto.isSupply1();
						boolean supply2 = petDto.isSupply2();

						while ((hp > 0 && fullness > 0 && love > 0)
								&& (hp < 60 || fullness < 60 || love < 60 || (hp + fullness + love) / 3 < 70)) {

							System.out.println("[0]로그인 이동 [1]상태보기 [2]가방확인 [3]알바하기(돈+6000) [4]병원가기 [5]놀아주기 [6]잠재우기(저장)");
							int choice = sc.nextInt();

							if (choice == 1) {
								ConsoleClear();
								System.out.println("========== " + name + "의 상태 ==========");
								System.out.println("건강 : " + hp);
								System.out.println("포만감 : " + fullness);
								System.out.println("애정 : " + love);
								System.out.println();

							} else if (choice == 2) {
								ConsoleClear();
								System.out.println("========== 가방 ==========");
								System.out.println("돈 : " + money + "원");
								System.out.println("간식");
								System.out.println("사료");
								if(supply1 == true) {
									if(spec.equals(sc))
									System.out.println("");
								}

							} else if (choice == 3) {
								ConsoleClear();
								System.out.println("========== 아르바이트 ==========");
								System.out.println(name + " 조금만 기다려...");

								try {
									// 2000 밀리초(2초) 동안 일시 중지
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}

								money = money + 6000;
								System.out.println("돈 6000원을 벌었습니다.");
								System.out.println();

							} else if (choice == 4) {
								ConsoleClear();
								System.out.println("========== 병원 입장 ==========");

								while ((hp > 0 && fullness > 0 && love > 0)
										&& (hp < 60 || fullness < 60 || love < 60 || (hp + fullness + love) / 3 < 70)) {
									System.out.print(
											"[0]집 이동 [1]간식(포만+10 애정+10) [2]사료(건강+5 포만+15 애정+5) [3]진료(건강+20) [4]장난감(애정+15) [5]애견용품");
									int hosChoice = sc.nextInt();

									if (hosChoice == 1) {
										ConsoleClear();
										System.out.println("========== 간식주기 ==========");
										money -= 3000;// 여기 0에는 감소되는 금액 작성
										hp -= 5;
										fullness += 10;
										love += 10;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 2) {
										ConsoleClear();
										System.out.println("========== 사료주기 ==========");
										money -= 4000;
										hp += 5;
										fullness += 15;
										love += 5;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 3) {
										ConsoleClear();
										System.out.println("========== 진료받기 ==========");
										money -= 3000;
										hp += 20;
										fullness -= 20;
										love -= 30;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 4) {
										ConsoleClear();
										System.out.println("========== 장난감주기 ==========");
										money -= 2500;
										hp -= 5;
										fullness -= 15;
										love += 15;
										printInfo(name, hp, fullness, love, money);
									} else if (hosChoice == 5) {
										ConsoleClear();
										if (spec.equals("강아지")) {
											while ((hp > 0 && fullness > 0 && love > 0) && (hp < 60 || fullness < 60
													|| love < 60 || (hp + fullness + love) / 3 < 70)) {
												System.out.println("[0]나가기 [1]옷사기(애정+5) [2]목줄사기(애정+5) [3]삑삑이(애정+5)");
												int hosDogChoice = sc.nextInt();
												if (hosDogChoice == 1) {
													ConsoleClear();
													System.out.println("옷을 획득합니다.");
													money -= 1000;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 2) {
													ConsoleClear();
													supply1 = true;
													System.out.println("목줄을 획득합니다.");
													money -= 1500;
													hp -= 5;
													fullness -= 10;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 3) {
													ConsoleClear();
													boolean catwheel = true;
													System.out.println("삑삑이을 획득합니다.");
													money -= 1500;
													hp -= 5;
													fullness -= 10;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosDogChoice == 0) {
													ConsoleClear();
													break;
												}
											}
										}
										if (spec.equals("고양이")) {
											while ((hp > 0 && fullness > 0 && love > 0) && (hp < 60 || fullness < 60
													|| love < 60 || (hp + fullness + love) / 3 < 70)) {
												System.out.println("[0]나가기 [1]옷사기(애정+5) [2]캣휠(애정+5) [3]레이저(애정+5)");
												int hosCatChoice = sc.nextInt();
												if (hosCatChoice == 1) {
													ConsoleClear();
													System.out.println("옷을 획득합니다.");
													money -= 1000;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 2) {
													ConsoleClear();
													System.out.println("켓휠을 획득합니다.");
													boolean lead = true;
													money -= 1500;
													hp -= 5;
													fullness -= 10;
													love += 5;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 3) {
													ConsoleClear();
													System.out.println("레이저을 획득합니다.");
													boolean catwheel = true;
													money -= 1500;
													hp -= 0;
													fullness -= 0;
													love -= 0;
													printInfo(name, hp, fullness, love, money);
												} else if (hosCatChoice == 4) {
													ConsoleClear();
													break;
												}
											}
										}
									} else if (hosChoice == 0) {
										ConsoleClear();
										break;
									} else {
										System.out.println("번호를 다시 입력해주세요.");
									}
								}

							} else if (choice == 5) {
								ConsoleClear();
								System.out.println("========== 놀아주기 ==========");
								while ((hp > 0 && fullness > 0 && love > 0)
										&& (hp < 60 || fullness < 60 || love < 60 || (hp + fullness + love) / 3 < 70)) {
									if (spec.equals("강아지")) {
										System.out.println("[0]나가기 [1]산책(애정+15) [2]터그놀이(애정+10)");
										int playDogChoice = sc.nextInt();
										boolean lead = true;
										boolean dogToy = true;

										if (playDogChoice == 1) {
											ConsoleClear();
											System.out.println("========== 산책하기 ==========");
											if (lead == true) {
												// 딜레이 2초 넣기
												love += 15;
												fullness -= 15;
												hp -= 5;
											} else {
												System.out.println("목줄이 없어 산책을 할 수 없습니다ㅠㅠ");
											}
										} else if (playDogChoice == 2) {
											ConsoleClear();
											System.out.println("========== 터그놀이 ==========");
											if (dogToy == true) {
												love += 10;
												fullness -= 10;
												hp -= 5;
											} else {
												love += 5;
												fullness -= 10;
												hp -= 5;
											}
										} else if(playDogChoice == 0) {
											ConsoleClear();
											System.out.println("이전으로 돌아갑니다.");
											break;
										}

									} else if (spec.equals("고양이")) {

										System.out.println("[0]나가기 [1]캣휠(애정+15) [2]사냥놀이(애정+10)");
										int playCatChoice = sc.nextInt();
										boolean catWheel = true;
										boolean catToy = true;
										if (playCatChoice == 1) {
											ConsoleClear();
											System.out.println("========== 캣휠 ==========");
											if (catWheel == true) {
												// 딜레이 2초 넣기
												love += 15;
												fullness -= 15;
												hp -= 5;
											} else {
												ConsoleClear();
												System.out.println("캣휠이 없어서 캣휠을 태울 수 없습니다ㅠㅠ");
											}
										} else if (playCatChoice == 2) {
											ConsoleClear();
											System.out.println("========== 사냥놀이 ==========");
											if (catToy == true) {
												love += 10;
												fullness -= 10;
												hp -= 5;
											} else {
												ConsoleClear();
												System.out.println("사냥놀이 해줍니다.");
												love += 5;
												fullness -= 10;
												hp -= 5;
											}

										} else if(playCatChoice == 0) {
											ConsoleClear();
											System.out.println("이전으로 돌아갑니다.");
											break;
										}


									}
								}

							} else if (choice == 6) {
								ConsoleClear();
								System.out.println("========== 잠재우기 ==========");

								hp += 5;
								fullness -= 5;

								PetDTO lastPetDto = new PetDTO(name, spec, hp, fullness, love, money, supply1, supply2);

								int row = petDao.update(lastPetDto);

								if (row > 0) {
									System.out.println("펫 정보를 저장합니다.");
								} else {
									System.out.println("오류");
								}

							} else if (choice == 0) {
								System.out.println("로그인화면으로 돌아갑니다.");
								break;
							} else {
								System.out.println("번호를 다시 입력해주세요.");
							}

						}

						if (hp <= 0 || fullness <= 0 || love <= 0) {
							ConsoleClear();
							System.out.println("게임 실패 훗 가소롭군 넘모 못하네");
							// 게임 오버 시 해당 id의 동물 정보를 'delete'하기
						} else {
							if (spec.equals("강아지")) {
								ConsoleClear();
								System.out.println("훌륭한 강아지로 자랐습니다");
								// 훌륭한 강아지 정보 데이터 베이스에 'update'하기
							} else {
								ConsoleClear();
								System.out.println("훌륭한 고양이로 자랐습니다.");
								// 훌륭한 고양이 정보 데이터 베이스에 'update'하기
							}
						}

					}

				} else {
					ConsoleClear();
					System.out.println("로그인에 실패했습니다.");
					System.out.println("아이디와 비밀번호를 확인해주세요.");
				}
			} else if (input == 0) { // 게임종료
				ConsoleClear();
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				ConsoleClear();
				System.out.println("다시 입력해주세요.");
			}
		}

	}

	public static void printInfo(String name, int hp, int fullness, int love, int money) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("현재 " + name + "의 체력 :" + hp + "\t" + "포만감 :" + fullness + "\t" + "애정 :" + love);
		System.out.println("님의 잔액은" + money + "입니다.");
	}

	public static void ConsoleClear() {
		// 화면을 지우기 위해 여러 줄을 출력
		for (int i = 0; i < 50; ++i)
			System.out.println();

		// 여기에 나머지 코드를 작성하세요.

	}

}
