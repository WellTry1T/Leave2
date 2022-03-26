package com.innovation.user.leave;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectedCountry extends AppCompatActivity implements WayListAdapter.OnPlusListener {

    private ImageView bg;
    private ObjectAnimator objectanimator;
    private Button button_choice1;
    private Button button_choice2;
    private Button button_choice_country;
    private boolean show_anim2 = true;
    private ConstraintLayout cc3;
    private RecyclerView recyclerViewWay;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;
    private List<Way> wayList = new ArrayList<>();
    // private List<Description> newList = new ArrayList<>();
    private String country;
    private RecyclerView.ViewHolder wayViewHolder;
    private Way way;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_country);
        cc3 = findViewById(R.id.cc3);
        button_choice1 = findViewById(R.id.button_choice1);
        button_choice2 = findViewById(R.id.button_choice2);
        button_choice_country = findViewById(R.id.button_choice_country);
        bg = findViewById(R.id.bg);
        final RecyclerView recyclerViewWay = findViewById(R.id.recyclerViewWay);

        LinearLayoutManager llm = new LinearLayoutManager(SelectedCountry.this);
        recyclerViewWay.setLayoutManager(llm);

        Intent intent = getIntent();
        country = intent.getStringExtra("country");
        button_choice_country.setText(country);
        switch (country) {
            case ("Канада"):
                bg.setImageResource(getResources().getIdentifier("com.innovation.user.leave:drawable/" + "canada_selected", null, null));
                Way w1 = new Way("Express Entry \n(Иммиграция через работу).",
                        "Включает в себя 3 программы: \n1)Canadian Experience \n2)Class Federal Skilled Worker Program \n3)Federal Skilled  Trades Program \n\nОтбирает квалифицированных кандидатов из общего пула по количеству набранных баллов за опыт работы, \nязыковые навыки, образование, возраст и т.д\n\nНаиболее популярный способ иммиграции.",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w1.newList.add(new Description("Профиль", "Если способ подходит, необходимо создать аккаунт Express Entry, следуя инструкциям на официальном сайте посольства Канады.", R.drawable.ic_add));
                        w1.newList.add(new Description("Язык", "Необходимо сдать один из тестов на знание языка. \n\nДля английского языка: IELTS/CELPIP \nДля франузского языка(при иммиграции в Квебек): TCF/TEF", R.drawable.ic_add));
                        w1.newList.add(new Description("Документы для заполнения профиля","1)Паспорт или проездной документ. \n2)Результаты языкового теста. \n3)Подтверждение образования, полученного за пределами Канады. \n4)Номинация от провинции, если есть. ", R.drawable.ic_add));

                        wayList.add(w1);
                Way w2 = new Way("Provincial nominees \n(Иммиграция через провинцию).",
                        "Каждая провинция, кроме Квебека, имеет собственную программу по иммиграции на её территорию. \n\nИспользуется принцип Express Entry.",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w2.newList.add(new Description("Провинция", "Необходимо выбрать провинцию, чтобы стать её номинантом.", R.drawable.ic_add));
                        w2.newList.add(new Description("Требования", "Требования разнятся в зависимости от провинции. \nДля более полной информации посетите сайт провинции.", R.drawable.ic_add));
                        w2.newList.add(new Description("Документы(для любой провинции)", "Нужно пройти медицинское обследование и полицейскую проверку.", R.drawable.ic_add));

                        wayList.add(w2);

                Way w3 = new Way("Atlantic Immigration Pilot \n(Иммиграция через работу).",
                        "Помогает работодателям нанять квалифицированных кандидатов на работу в Атлантическую провинцию, которых не смогли найти в Канаде. \n\nВключает в себя 3 программы: \n1)Atlantic International Graduate Program \n2)Atlantic High-skilled Program \n3)Atlantic Intermediate-skilled Program",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w3.newList.add(new Description("Работа", "Необходимо получить предложение о работе от работадателя, участвующего в этой программе.", R.drawable.ic_add));
                        w3.newList.add(new Description("Язык", "Необходимо сдать один из тестов на знание языка. \n\nДля английского языка: IELTS/CELPIP \nДля франузского языка(при иммиграции в Квебек): TCF/TEF ", R.drawable.ic_add));
                        w3.newList.add(new Description("Образование", "Если вы учились за пределами Канады, вам нужно подтвердить полученное образование.", R.drawable.ic_add));
                        w3.newList.add(new Description("Деньги", "Необходимо доказать наличие денежных средств.", R.drawable.ic_add));

                        wayList.add(w3);

                Way w4 = new Way("Quebec-selected skilled workers \n(Иммиграция через работу).",
                        "Для квалифицированных рабочих, которые хотят стать постоянными жителями Канады и жить в Квебеке. \n\nПровинция имеет свои правила для выбора иммигрантов.",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w4.newList.add(new Description("Сертификат", "Обратиться в правительство Квебек для Квебек выбора сертификата. \n\n - Провинция Квебек будет оценивать вас, используя свои собственные правила. \n\n - Сертификат показывает, что в провинции Квебек принял вас в качестве иммигранта.", R.drawable.ic_add));
                        w4.newList.add(new Description("Подтверждение", "3 Основных шага: \n1)Получить пакет приложений и заполнить их. \n2)Оплатить сборы приложений. \n3)Отправить заявку.", R.drawable.ic_add));

                        wayList.add(w4);

                Way w5 = new Way("Start-up Visa \n(Иммиграция через бизнес).",
                        "Для предпринимателей с навыками и потенциалом для создания бизнеса в Канаде \n\nПровинция Квебек имеет собственную программу бизнес-иммиграции",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w5.newList.add(new Description("Условия", "1)Бизнес квалификация. \n2)Письмо поддержки от места, где был одобрен стартап. \n3)Языковой тест. \n4)Иметь достаточно средств для первого времени.", R.drawable.ic_add));
                        w5.newList.add(new Description("Подтверждение", "3 Основных шага: \n1)Получить пакет приложений и заполнить их. \n2)Оплатить сборы приложений. \n3)Отправить заявку.", R.drawable.ic_add));

                        wayList.add(w5);

                Way w6 = new Way("Family sponsorship \n(Иммиграция через семейное спонсорство).",
                        "По Канадским законам любой житель Канады, гражданин или имеющий статус постоянного жителя, достигший возраста 18 лет, имеет право оказать спонсорство своим близким родственникам с тем, чтобы они получили иммиграционную визу в Канаду.",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w6.newList.add(new Description("Условия", "Вы должны быть в состоянии: \n\n1)Поддержать их финансово. \n2)Убедитесь, что они не нуждаются в социальной помощи от государства.", R.drawable.ic_add));
                        w6.newList.add(new Description("Подтверждение", "3 Основных шага: \n1)Получить пакет приложений и заполнить их. \n2)Оплатить сборы приложений. \n3)Отправить заявку.", R.drawable.ic_add));

                        wayList.add(w6);

                Way w7 = new Way("Caregivers \n(Иммиграция через воспитание).",
                        "Для нянь и сиделок, желающих работать и жить в доме работодателя. \n\nВключает в себя 4 программы: \n1)Interim Pathway for Caregivers \n2)Caring for Children Program \n3)Caring for People with High Medical Needs Program \n4)Live-in Caregiver Program",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w7.newList.add(new Description("Требования", "Требования разнятся в зависимости от выбранной программы. \nДля более полной информации посетите официальный сайт посольства.", R.drawable.ic_add));

                        wayList.add(w7);

                Way w8 = new Way("Refugees and asylum \n(Иммиграция через беженство).",
                        "Для беженцев, желающих подать заявление на статус беженца изнутри Канады. \n\nПредоставление защиты и помощь лицам, которые в этом нуждаются. Для этого придется доказать, что возможности оставаться на своей родине или вернуться туда нет. ",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w8.newList.add(new Description("Условия", "Вы должны доказать, что ваще прошение об убежище небезосновательно.", R.drawable.ic_add));

                        wayList.add(w8);

                Way w9 = new Way("Self-employed \n(Иммиграция через самозанятость).",
                        "Для самозанятых людей. \n\nВы должны: \n1)Обладать соответствующим опытом в культурной деятельности или спорта. \n2)Быть готовы и способны внести значительный вклад в культурную или спортивную жизнь Канады.",
                        R.drawable.ic_circle, R.drawable.ic_add, R.id.description);
                        w9.newList.add(new Description("Условия", "Вы должны: \n\n1)Обладать соответствующим опытом в культурной деятельности или спорте. \n2)Быть готовы и способны внести значительный вклад в культурную или спортивную жизнь Канады. \n3)Соответствовать программе по критериям отбора. \n4)Удовлетворять медицинские и другие условия. \n\n", R.drawable.ic_add));
                        w9.newList.add(new Description("Подтверждение", "3 Основных шага: \n\n1)Получить пакет приложений и заполнить их. \n2)Оплатить сборы приложений. \n3)Отправить заявку.", R.drawable.ic_add));

                        wayList.add(w9);
                break;
        }


        final WayListAdapter adapter = new WayListAdapter(wayList, this);
        recyclerViewWay.setAdapter(adapter);


        button_choice1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (show_anim2) {
                    recyclerViewWay.setVisibility(View.GONE);
                    button_choice_country.setText("Выбрать");
                    revertAnimation();
                    bg.setImageResource(R.drawable.bg_main);
                    ObjectAnimator.ofFloat(bg, "alpha", 0.0f, 1.0f).start();
                } else {
                    showAnimation();
                    bg.setImageResource(R.drawable.bg_change1);
                    ObjectAnimator.ofFloat(bg, "alpha", 0.0f, 1.0f).start();
                }
            }
        });

        button_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        button_choice_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectedCountry.this, ChoiceCountry.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showAnimation() {
        show_anim2 = true;

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.change_1);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(600);

        TransitionManager.beginDelayedTransition(cc3, transition);
        constraintSet.applyTo(cc3);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void revertAnimation() {
        show_anim2 = false;

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.activity_main);

        ChangeBounds transition = new ChangeBounds();
        transition.setInterpolator(new AnticipateInterpolator(1.0f));
        transition.setDuration(600);

        TransitionManager.beginDelayedTransition(cc3, transition);
        constraintSet.applyTo(cc3);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onPlusClick(View v, int position) {
        wayList.get(position).setImageChanged(true);
    }

    @Override
    public void onDescClick(View v, int position) {
        Intent intent = new Intent(SelectedCountry.this, DescriptionCountry.class);

        ArrayList<String> listStr = new ArrayList<>();
        Way w = wayList.get(position);
        List<Description> descrList = w.newList;
        for (Description ddr : descrList) {
            listStr.add(ddr.titleDesc);
            listStr.add(ddr.mainDesc);
        }
        System.out.println(listStr);

        intent.putStringArrayListExtra("List", listStr);
        startActivity(intent);
    }
}
